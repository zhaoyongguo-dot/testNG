package com.okhttp_review;

public class Constant {
    /**
     * 注意常量是Public 类型 否则其他地方引用不了
     */
    public static final String BASE_URL = "http://apis.juhe.cn/";

    public static final String MOBILE_LOCAL_URL = BASE_URL + "mobile/get";
    public static final String WEATHER_URL = BASE_URL + "simpleWeather/query";
}
