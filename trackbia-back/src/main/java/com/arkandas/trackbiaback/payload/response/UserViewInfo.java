package com.arkandas.trackbiaback.payload.response;

import java.util.List;

public class UserViewInfo {

    private ViewInfo viewInfo;
    private List<QrViews> qrInfo = null;

    public ViewInfo getViewInfo() {
        return viewInfo;
    }

    public void setViewInfo(ViewInfo viewInfo) {
        this.viewInfo = viewInfo;
    }

    public List<QrViews> getQrInfo() {
        return qrInfo;
    }

    public void setQrInfo(List<QrViews> qrInfo) {
        this.qrInfo = qrInfo;
    }

}
