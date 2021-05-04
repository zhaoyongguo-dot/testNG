package com.okhttp;

import com.alibaba.fastjson.JSONObject;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Weather {

    private final static Logger LOGGER = LoggerFactory.getLogger(Weather.class);
    @Test(dataProvider = "datas")
    public void testWeather(String params) {
        String url = Constants.WEATHER;
        String method = "post";
        Response response = HttpUtil.call(method, url, params);
        String responsebody = null;
        try {
            responsebody = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("-----TestLogException----", e.getMessage());
        }
        JSONObject jsonObject = JSONObject.parseObject(responsebody);
        String resultcode = (String)jsonObject.get("resultcode");
        LOGGER.info("responsecode is :{}", response.code());
        LOGGER.info("resultcode is :{}", resultcode);
        LOGGER.info("body is :{}", responsebody);
        LOGGER.info("params :{}", params);
    }

    @DataProvider(name = "datas")
    public Object[][] datas() {
        return new Object[][] {
            {"city=上海&key=cd4587926813ec16367deb93688301aa"},
            {"city=bengbu&key=cd4587926813ec16367deb93688301aa"},
            {"city=上海&key=cd4587926813ec16367deb93688301a"},
        };
    }
}
