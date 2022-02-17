package com.arkandas.trackbiaback.models;

public class ViewInfoGeneral {

    private Integer totalViews;
    private Integer uniqueVisitors;
    private Integer countries;
    private Integer lastDay;
    private Integer lastWeek;
    private Integer lastMonth;

    public ViewInfoGeneral() {
        super();
    }

    public ViewInfoGeneral(Integer totalViews, Integer uniqueVisitors, Integer countries, Integer lastDay, Integer lastWeek, Integer lastMonth) {
        this.totalViews = totalViews;
        this.uniqueVisitors = uniqueVisitors;
        this.countries = countries;
        this.lastDay = lastDay;
        this.lastWeek = lastWeek;
        this.lastMonth = lastMonth;
    }

    public Integer getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(Integer totalViews) {
        this.totalViews = totalViews;
    }

    public Integer getUniqueVisitors() {
        return uniqueVisitors;
    }

    public void setUniqueVisitors(Integer uniqueVisitors) {
        this.uniqueVisitors = uniqueVisitors;
    }

    public Integer getCountries() {
        return countries;
    }

    public void setCountries(Integer countries) {
        this.countries = countries;
    }

    public Integer getLastDay() {
        return lastDay;
    }

    public void setLastDay(Integer lastDay) {
        this.lastDay = lastDay;
    }

    public Integer getLastWeek() {
        return lastWeek;
    }

    public void setLastWeek(Integer lastWeek) {
        this.lastWeek = lastWeek;
    }

    public Integer getLastMonth() {
        return lastMonth;
    }

    public void setLastMonth(Integer lastMonth) {
        this.lastMonth = lastMonth;
    }

    @Override
    public String toString() {
        return "ViewInfoGeneral{" +
                "totalViews=" + totalViews +
                ", uniqueVisitors=" + uniqueVisitors +
                ", countries=" + countries +
                ", lastDay=" + lastDay +
                ", lastWeek=" + lastWeek +
                ", lastMonth=" + lastMonth +
                '}';
    }

}
