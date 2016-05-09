package com.yt.android.entity;

import java.io.Serializable;

/**
 * 用来获取天气的json对象
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.entity
 * @date 2016/5/9 0009 16:53
 * @descption: 疯狂的王麻子团队!
 */
public class WeatherInfo implements Serializable {

    private CityWeatherInfo weatherinfo;


    public WeatherInfo() {
    }

    public WeatherInfo(CityWeatherInfo weatherinfo) {
        this.weatherinfo = weatherinfo;
    }

    public CityWeatherInfo getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(CityWeatherInfo weatherinfo) {
        this.weatherinfo = weatherinfo;
    }
}
