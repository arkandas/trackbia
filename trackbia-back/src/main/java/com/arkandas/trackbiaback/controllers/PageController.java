package com.arkandas.trackbiaback.controllers;


import com.arkandas.trackbiaback.location.RawDBGeoIPLocationService;
import com.arkandas.trackbiaback.location.RequestService;
import com.arkandas.trackbiaback.models.*;
import com.arkandas.trackbiaback.payload.request.UserView;
import com.arkandas.trackbiaback.payload.response.*;
import com.arkandas.trackbiaback.repository.PageRepository;
import com.arkandas.trackbiaback.repository.QrRepository;
import com.arkandas.trackbiaback.repository.UserRepository;
import com.arkandas.trackbiaback.security.SecCryptoView;
import com.arkandas.trackbiaback.security.jwt.JwtUtils;
import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/page")
public class PageController {

    private RawDBGeoIPLocationService locationService;

    private static final Logger LOG = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private RequestService requestService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    QrRepository qrRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @RequestMapping(value = "/qrviews", method = RequestMethod.GET)
    public UserViewInfo getAllPageViewsByUserId(HttpServletRequest request, @RequestHeader(value = "Authorization") @NotNull String token) throws Exception {
        LOG.info("--- /qrviews ---");

        String username = jwtUtils.getUserNameFromJwtToken(token.substring(7, token.length()));
        Long userId = userRepository.findByUsername(username).get().getId();

        UserViewInfo userViewInfo = new UserViewInfo();
        ViewInfo viewInfo = new ViewInfo();
        viewInfo.setTotalQr(qrRepository.getTotalQRsByUserId(Math.toIntExact(userId)));
        viewInfo.setTotalViews(pageRepository.getTotalPageViews(Math.toIntExact(userId)));
        viewInfo.setTotalDay(pageRepository.getTotalPageViewsLastXDays("1 day",Math.toIntExact(userId)));
        viewInfo.setTotalWeek(pageRepository.getTotalPageViewsLastXDays("7 days", Math.toIntExact(userId)));
        viewInfo.setTotalMonth(pageRepository.getTotalPageViewsLastXDays("30 days", Math.toIntExact(userId)));


        List<QrViews> QrInfo = pageRepository.getQrTotalViewsByUserId(Math.toIntExact(userId)).stream()
                .map(s -> s.replaceAll("", "").split(","))
                .map(a -> new QrViews(a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7]))
                .collect(toList());

        userViewInfo.setViewInfo(viewInfo);
        userViewInfo.setQrInfo(QrInfo);

        return userViewInfo;
    }


    @GetMapping("/totalviews/{hash_id}")
//    @PreAuthorize("hasRole('USER')")
    public ViewInfoGeneral getTotalViews(@PathVariable("hash_id") String hashId) {

        ViewInfoGeneral viewInfo = new ViewInfoGeneral();
        viewInfo.setTotalViews(pageRepository.getTotalPageViews(hashId));
        viewInfo.setUniqueVisitors(pageRepository.getUniqueVisitors(hashId));
        viewInfo.setCountries(pageRepository.getUniqueCountries(hashId));
        viewInfo.setLastDay(pageRepository.getTotalViewsLastXDaysHashId("1 day", hashId));
        viewInfo.setLastWeek(pageRepository.getTotalViewsLastXDaysHashId("7 days", hashId));
        viewInfo.setLastMonth(pageRepository.getTotalViewsLastXDaysHashId("30 days", hashId));
        return viewInfo;

    }

    @GetMapping("/lastviews/{hash_id}")
//    @PreAuthorize("hasRole('USER')")
    public List<LastViews> getLast1000PageViews(@PathVariable("hash_id") String hashId) {
        LOG.info("--- /lastviews ---");
        List<LastViews> collect = pageRepository.findLast1000VisitorsWeb(hashId).stream()
                .map(s -> s.replaceAll("", "").split(","))
                .map(a -> new LastViews(a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7]))
                .collect(toList());
        return collect;
    }

    @GetMapping("/viewsbyip/{hash_id}")
//    @PreAuthorize("hasRole('USER')")
    public List<IPCoordinates> getViewsByIP(@PathVariable("hash_id") String hashId) {
        LOG.info("--- /lastviews ---");
        List<IPCoordinates> collect = pageRepository.findDistinctIpAddress(hashId).stream()
                .map(s -> s.replaceAll("", "").split(","))
                .map(a -> new IPCoordinates(a[0], a[1], a[2], a[3], a[4], a[5], a[6]))
                .collect(toList());

        return collect;
    }



}
