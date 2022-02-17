package com.arkandas.trackbiaback.models;

public class LastViews {

    private String ipAddress;
    private String timestamp;
    private String blogPage;
    private String country;
    private String countryIsoCode;
    private String city;
    private String postalCode;
    private String asnOperator;

    public LastViews(String ipAddress, String timestamp, String blogPage, String country, String countryIsoCode, String city, String postalCode, String asnOperator) {
        this.ipAddress = ipAddress;
        this.timestamp = timestamp;
        this.blogPage = blogPage;
        this.country = country;
        this.countryIsoCode = countryIsoCode;
        this.city = city;
        this.postalCode = postalCode;
        this.asnOperator = asnOperator;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBlogPage() {
        return blogPage;
    }

    public void setBlogPage(String blogPage) {
        this.blogPage = blogPage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAsnOperator() {
        return asnOperator;
    }

    public void setAsnOperator(String asnOperator) {
        this.asnOperator = asnOperator;
    }

    @Override
    public String toString() {
        return "LastViews{" +
                "ipAddress='" + ipAddress + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", blogPage='" + blogPage + '\'' +
                ", country='" + country + '\'' +
                ", countryIsoCode='" + countryIsoCode + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", asnOperator='" + asnOperator + '\'' +
                '}';
    }
}
