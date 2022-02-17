package com.arkandas.trackbiaback.payload.response;

import java.util.Date;

public class QrViews {

    private String Id;
    private String creationDate;
    private String description;
    private String hashId;
    private String type;
    private String url;
    private String user_id;
    private String totalViews;

    public QrViews(String id, String creationDate, String description, String hashId, String type, String url, String user_id, String totalViews) {
        Id = id;
        this.creationDate = creationDate;
        this.description = description;
        this.hashId = hashId;
        this.type = type;
        this.url = url;
        this.user_id = user_id;
        this.totalViews = totalViews;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(String totalViews) {
        this.totalViews = totalViews;
    }
}
