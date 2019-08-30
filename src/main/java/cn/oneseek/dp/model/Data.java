package cn.oneseek.dp.model;

import java.util.Date;

public class Data {
    private Integer id;

    private String datetime;

    private Float airtemp1;

    private Float plotid;

    private Float airhumi1;

    private Float soiltemp1;

    private Float soilhumi1;

    private Float sundata1;

    private Float co2;

    private Float soilhumi5;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Float getAirtemp1() {
        return airtemp1;
    }

    public void setAirtemp1(Float airtemp1) {
        this.airtemp1 = airtemp1;
    }

    public Float getPlotid() {
        return plotid;
    }

    public void setPlotid(Float plotid) {
        this.plotid = plotid;
    }

    public Float getAirhumi1() {
        return airhumi1;
    }

    public void setAirhumi1(Float airhumi1) {
        this.airhumi1 = airhumi1;
    }

    public Float getSoiltemp1() {
        return soiltemp1;
    }

    public void setSoiltemp1(Float soiltemp1) {
        this.soiltemp1 = soiltemp1;
    }

    public Float getSoilhumi1() {
        return soilhumi1;
    }

    public void setSoilhumi1(Float soilhumi1) {
        this.soilhumi1 = soilhumi1;
    }

    public Float getSundata1() {
        return sundata1;
    }

    public void setSundata1(Float sundata1) {
        this.sundata1 = sundata1;
    }

    public Float getCo2() {
        return co2;
    }

    public void setCo2(Float co2) {
        this.co2 = co2;
    }

    public Float getSoilhumi5() {
        return soilhumi5;
    }

    public void setSoilhumi5(Float soilhumi5) {
        this.soilhumi5 = soilhumi5;
    }


    @Override
    public String toString() {
        return "{" +
                "'id':" + id +
                ", 'datetime':" + datetime +
                ", 'airtemp1':" + airtemp1 +
                ", 'plotid':" + plotid +
                ", 'airhumi1':" + airhumi1 +
                ", 'soiltemp1':" + soiltemp1 +
                ", 'soilhumi1':" + soilhumi1 +
                ", 'sundata1':" + sundata1 +
                ", 'co2':" + co2 +
                ", 'soilhumi5':" + soilhumi5 +
                '}';
    }
}