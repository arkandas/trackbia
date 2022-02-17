package com.arkandas.trackbiaback.models;

public class IPCoordinates {

    private String ipAddress;
    private String city;
    private String country;
    private String asnNumber;
    private String asnOperator;
    private String latitude;
    private String longitude;

    public IPCoordinates(String ipAddress, String city, String country, String asnNumber, String asnOperator, String latitude, String longitude) {
        this.ipAddress = ipAddress;
        this.city = city;
        this.country = country;
        this.asnNumber = asnNumber;
        this.asnOperator = asnOperator;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
}