package com.arkandas.trackbiaback.payload.response;

public class GeoIP {
    private String ipAddress;
    private String city;
    private String timeZone;
    private String latitude;
    private String longitude;
    private String country;
    private String countryISOCode;
    private String postal;
    private String asnNumber;
    private String asnOperator;

    public GeoIP(String ipAddress, String city, String timeZone, String latitude, String longitude, String country, String countryISOCode, String postal, String asnNumber, String asnOperator) {
        this.ipAddress = ipAddress;
        this.city = city;
        this.timeZone = timeZone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.countryISOCode = countryISOCode;
        this.postal = postal;
        this.asnNumber = asnNumber;
        this.asnOperator = asnOperator;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryISOCode() {
        return countryISOCode;
    }

    public void setCountryISOCode(String countryISOCode) {
        this.countryISOCode = countryISOCode;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getAsnNumber() {
        return asnNumber;
    }

    public void setAsnNumber(String asnNumber) {
        this.asnNumber = asnNumber;
    }

    public String getAsnOperator() {
        return asnOperator;
    }

    public void setAsnOperator(String asnOperator) {
        this.asnOperator = asnOperator;
    }

    @Override
    public String toString() {
        return "GeoIP{" +
                "ipAddress='" + ipAddress + '\'' +
                ", city='" + city + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", country='" + country + '\'' +
                ", countryISOCode='" + countryISOCode + '\'' +
                ", postal='" + postal + '\'' +
                ", asnNumber='" + asnNumber + '\'' +
                ", asnOperator='" + asnOperator + '\'' +
                '}';
    }
}
