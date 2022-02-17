package com.arkandas.trackbiaback.location;

import com.arkandas.trackbiaback.payload.response.GeoIP;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.AsnResponse;
import com.maxmind.geoip2.model.CityResponse;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class RawDBGeoIPLocationService {
    private DatabaseReader dbReaderCity;
    private DatabaseReader getDbReaderASN;

    public RawDBGeoIPLocationService() throws IOException {
        File databaseCity = new File("/home/ubuntu/dbIP/GeoLite2-City.mmdb");
        File databaseASN = new File("/home/ubuntu/dbIP/GeoLite2-ASN.mmdb");
        dbReaderCity = new DatabaseReader.Builder(databaseCity).build();
        getDbReaderASN = new DatabaseReader.Builder(databaseASN).build();

    }

    public GeoIP getLocation(String ip) throws IOException, GeoIp2Exception {

        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = dbReaderCity.city(ipAddress);
        AsnResponse asnResponse = getDbReaderASN.asn(ipAddress);

        String cityName = response.getCity().getName();
        String countryIsoCode = response.getCountry().getIsoCode();
        String timeZone = response.getLocation().getTimeZone();
        String latitude = response.getLocation().getLatitude().toString();
        String longitude = response.getLocation().getLongitude().toString();
        String country = response.getCountry().getName();
        String postal = response.getPostal().getCode();
        String asnNumber = asnResponse.getAutonomousSystemNumber().toString();
        String asnOperator = asnResponse.getAutonomousSystemOrganization();

        return new GeoIP(ip, cityName, timeZone, latitude, longitude, country,countryIsoCode, postal, asnNumber, asnOperator);

    }
}
