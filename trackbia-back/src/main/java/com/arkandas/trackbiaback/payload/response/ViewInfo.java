package com.arkandas.trackbiaback.payload.response;

public class ViewInfo {

    private Integer totalViews;
    private Integer totalQr;
    private Integer totalDay;
    private Integer totalWeek;
    private Integer totalMonth;

    public Integer getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(Integer totalViews) {
        this.totalViews = totalViews;
    }

    public Integer getTotalQr() {
        return totalQr;
    }

    public void setTotalQr(Integer totalQr) {
        this.totalQr = totalQr;
    }

    public Integer getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(Integer totalDay) {
        this.totalDay = totalDay;
    }

    public Integer getTotalWeek() {
        return totalWeek;
    }

    public void setTotalWeek(Integer totalWeek) {
        this.totalWeek = totalWeek;
    }

    public Integer getTotalMonth() {
        return totalMonth;
    }

    public void setTotalMonth(Integer totalMonth) {
        this.totalMonth = totalMonth;
    }

}