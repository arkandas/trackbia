package com.arkandas.trackbiaback.controllers;


import com.arkandas.trackbiaback.location.RawDBGeoIPLocationService;
import com.arkandas.trackbiaback.location.RequestService;
import com.arkandas.trackbiaback.models.PageView;
import com.arkandas.trackbiaback.models.QrCode;
import com.arkandas.trackbiaback.payload.request.UserView;
import com.arkandas.trackbiaback.payload.response.GeoIP;
import com.arkandas.trackbiaback.payload.response.MessageResponse;
import com.arkandas.trackbiaback.repository.PageRepository;
import com.arkandas.trackbiaback.repository.QrRepository;
import com.arkandas.trackbiaback.repository.UserRepository;
import com.arkandas.trackbiaback.security.SecCryptoView;
import com.arkandas.trackbiaback.security.jwt.JwtUtils;
import com.arkandas.trackbiaback.security.services.UserDetailsServiceImpl;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/qr")
public class QrController {

    private static final Logger logger = LoggerFactory.getLogger(QrController.class);

    private RawDBGeoIPLocationService locationService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    QrRepository qrRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private RequestService requestService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/createqr")
    public ResponseEntity<?> createNewQrCode(@Valid @RequestBody QrCode qrCode, @RequestHeader(value = "Authorization") @NotNull String token) {
        if (qrRepository.existsByHashId(qrCode.getHashId())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Qr Code with that id already exists"));
        }

        if (qrRepository.existsByUrl(qrCode.getUrl())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Qr Code with that url already exists"));
        }

        String username = jwtUtils.getUserNameFromJwtToken(token.substring(7, token.length()));
        Long userId = userRepository.findByUsername(username).get().getId();
        qrCode.setUserId(Math.toIntExact(userId));

        qrRepository.save(qrCode);
        logger.info("Qr Code with hashId: " + qrCode.getHashId() + " created successfully");
        return ResponseEntity.ok(new MessageResponse("Qr Code created successfully!"));
    }

    @GetMapping("/{qr_code}")
//    @PreAuthorize("hasRole('USER')")
    public Object findQrCodeByHashId(@PathVariable("qr_code") String hashId) {
//        Add UserCheckToQr
        if (!qrRepository.existsByHashId(hashId)) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Qr Code with that id does not exist"));
        }
        return qrRepository.findByHashId(hashId);
    }

    @PostMapping("/update/{qr_code}")
    public ResponseEntity<?> updateQRCode(@PathVariable("qr_code") String hashId,@Valid @RequestBody String qrDescription ) {

        Optional<QrCode> qrCode = qrRepository.findByHashId(hashId);
        qrCode.get().setDescription(qrDescription);
        qrRepository.save(qrCode.get());
        return ResponseEntity.ok(new MessageResponse("Qr updated successfully!"));
    }

    @PostMapping("/delete/{qr_code}")
    public ResponseEntity<?> deleteQRCode(@PathVariable("qr_code") String hashId) {

        Optional<QrCode> qrCode = qrRepository.findByHashId(hashId);
        qrRepository.deleteById(qrCode.get().getId());
        pageRepository.deleteAllByHashId(qrCode.get().getHashId());
        return ResponseEntity.ok(new MessageResponse("Qr deleted successfully!"));
    }


    @PostMapping("/qrview")
    public ResponseEntity<?> createNewQrCodeView(@Valid @RequestBody UserView requestBody, HttpServletRequest request) throws IOException, GeoIp2Exception {

        String ipAddress = requestService.getClientIp(request);
        ipAddress = "37.222.31.22";

        Boolean isEqual = true;

        if (isEqual) {
            if (ipAddress.equals("127.0.1.1") || ipAddress.equals("127.0.0.1") || ipAddress.startsWith("192.168") || requestBody.getHashId().equals("default")) {
                logger.info("Internal IP: " + ipAddress);
            } else {
                Optional<QrCode> myQr =  qrRepository.findByHashId(requestBody.getHashId());

                if(myQr.isPresent()){

                    logger.info("Insert Data Into DDBB");
                    logger.info("External IP: " + ipAddress);

                    PageView pageView = new PageView();
                    locationService = new RawDBGeoIPLocationService();

                    pageView.setViewId(null);
                    pageView.setTimeStamp(Timestamp.from(Instant.now()));
                    pageView.setPage(requestBody.getPage());
                    pageView.setIpAddress(ipAddress);
                    GeoIP geoInfo = locationService.getLocation(ipAddress);
                    pageView.setCity(geoInfo.getCity());
                    pageView.setCountry(geoInfo.getCountry());
                    pageView.setCountryIsoCode(geoInfo.getCountryISOCode());
                    pageView.setPostalCode(geoInfo.getPostal());
                    pageView.setLatitude(geoInfo.getLatitude());
                    pageView.setLongitude(geoInfo.getLongitude());
                    pageView.setTimeZone(geoInfo.getTimeZone());
                    pageView.setAsnNumber(geoInfo.getAsnNumber());
                    pageView.setAsnOperator(geoInfo.getAsnOperator());
                    pageView.setUserBrowser(requestBody.getUserBrowser());
                    pageView.setUserOS(requestBody.getUserOS());
                    pageView.setUserDevice(requestBody.getUserDevice());
                    pageView.setUserDeviceType(requestBody.getUserDeviceType());
                    pageView.setUserBrowserVersion(requestBody.getUserBrowserVersion());
                    pageView.setUserOSVersion(requestBody.getUserOSVersion());
                    pageView.setUserId(myQr.get().getUserId());
                    pageView.setHashId(requestBody.getHashId());
                    logger.info("Page Information: " + pageView.toString());
                    pageRepository.save(pageView);
                }else {
                    return ResponseEntity.ok(new MessageResponse("Qr Code does not exist!"));
                }
            }
        }

        return ResponseEntity.ok(new MessageResponse("Qr Code View created successfully!"));
    }



}
