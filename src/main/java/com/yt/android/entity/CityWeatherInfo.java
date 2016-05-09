package com.yt.android.entity;

import java.io.Serializable;

/**
 * 工具类用来获取天气的
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.entity
 * @date 2016/5/9 0009 16:53
 * @descption: 疯狂的王麻子团队!
 */
public class CityWeatherInfo implements Serializable {
    private String city;
    private String cityid;
    private String temp1;
    private String temp2;
    private String weather;
    private String ptime;


    public CityWeatherInfo() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }
}
