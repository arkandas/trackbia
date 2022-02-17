package com.arkandas.trackbiaback.payload.request;

public class UserView {

    private String page;
    private String hashId;
    private String userBrowser;
    private String userBrowserVersion;
    private String userDevice;
    private String userDeviceType;
    private String userOS;
    private String userOSVersion;
    private String date;

    public UserView() {
    }

    public UserView(String page, String hashId, String userBrowser, String userBrowserVersion, String userDevice, String userDeviceType, String userOS, String userOSVersion, String date) {
        this.page = page;
        this.hashId = hashId;
        this.userBrowser = userBrowser;
        this.userBrowserVersion = userBrowserVersion;
        this.userDevice = userDevice;
        this.userDeviceType = userDeviceType;
        this.userOS = userOS;
        this.userOSVersion = userOSVersion;
        this.date = date;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "UserView{" +
                "page='" + page + '\'' +
                ", hashId='" + hashId + '\'' +
                ", userBrowser='" + userBrowser + '\'' +
                ", userBrowserVersion='" + userBrowserVersion + '\'' +
                ", userDevice='" + userDevice + '\'' +
                ", userDeviceType='" + userDeviceType + '\'' +
                ", userOS='" + userOS + '\'' +
                ", userOSVersion='" + userOSVersion + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}