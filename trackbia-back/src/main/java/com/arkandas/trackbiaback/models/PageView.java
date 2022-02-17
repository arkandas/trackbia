package com.arkandas.trackbiaback.models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "pageview")
@Table(name = "pageview")
public class PageView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id\"")
    private Long viewId;

    @Column(name = "\"timestamp\"", columnDefinition = "timestamp with time zone not null")
    private Date timeStamp;

    @Column(name = "\"page\"")
    private String page;

    @Column(name = "\"ip_address\"")
    private String ipAddress;

    @Column(name = "\"city\"")
    private String city;

    @Column(name = "\"country\"")
    private String country;

    @Column(name = "\"country_iso_code\"")
    private String countryIsoCode;

    @Column(name = "\"postal_code\"")
    private String postalCode;

    @Column(name = "\"latitude\"")
    private String latitude;

    @Column(name = "\"longitude\"")
    private String longitude;

    @Column(name = "\"time_zone\"")
    private String timeZone;

    @Column(name = "\"asn_number\"")
    private String asnNumber;

    @Column(name = "\"asn_operator\"")
    private String asnOperator;

    @Column(name = "\"user_browser\"")
    private String userBrowser;

    @Column(name = "\"user_browser_version\"")
    private String userBrowserVersion;

    @Column(name = "\"user_device\"")
    private String userDevice;

    @Column(name = "\"user_device_type\"")
    private String userDeviceType;

    @Column(name = "\"user_os\"")
    private String userOS;

    @Column(name = "\"user_os_version\"")
    private String userOSVersion;

    @Column(name = "\"hash_id\"")
    private String hashId;

    private Integer userId;


    public PageView() {
        super();
    }

    public PageView(Long viewId, Date timeStamp, String page, String ipAddress, String city, String country, String countryIsoCode, String postalCode, String latitude, String longitude, String timeZone, String asnNumber, String asnOperator, String userBrowser, String userBrowserVersion, String userDevice, String userDeviceType, String userOS, String userOSVersion, String hashId, Integer userId) {
        this.viewId = viewId;
        this.timeStamp = timeStamp;
        this.page = page;
        this.ipAddress = ipAddress;
        this.city = city;
        this.country = country;
        this.countryIsoCode = countryIsoCode;
        this.postalCode = postalCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timeZone = timeZone;
        this.asnNumber = asnNumber;
        this.asnOperator = asnOperator;
        this.userBrowser = userBrowser;
        this.userBrowserVersion = userBrowserVersion;
        this.userDevice = userDevice;
        this.userDeviceType = userDeviceType;
        this.userOS = userOS;
        this.userOSVersion = userOSVersion;
        this.hashId = hashId;
        this.userId = userId;
    }

    public Long getViewId() {
        return viewId;
    }

    public void setViewId(Long viewId) {
        this.viewId = viewId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
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

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
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

    public String getUserBrowser() {
        return userBrowser;
    }

    public void setUserBrowser(String userBrowser) {
        this.userBrowser = userBrowser;
    }

    public String getUserBrowserVersion() {
        return userBrowserVersion;
    }

    public void setUserBrowserVersion(String userBrowserVersion) {
        this.userBrowserVersion = userBrowserVersion;
    }

    public String getUserDevice() {
        return userDevice;
    }

    public void setUserDevice(String userDevice) {
        this.userDevice = userDevice;
    }

    public String getUserDeviceType() {
        return userDeviceType;
    }

    public void setUserDeviceType(String userDeviceType) {
        this.userDeviceType = userDeviceType;
    }

    public String getUserOS() {
        return userOS;
    }

    public void setUserOS(String userOS) {
        this.userOS = userOS;
    }

    public String getUserOSVersion() {
        return userOSVersion;
    }

    public void setUserOSVersion(String userOSVersion) {
        this.userOSVersion = userOSVersion;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}