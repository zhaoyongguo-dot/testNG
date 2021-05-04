package com.okhttp;

import com.alibaba.fastjson.JSONObject;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class MobileLocal {

    private final static Logger LOGGER = LoggerFactory.getLogger(MobileLocal.class);
    @Test(dataProvider = "datas", alwaysRun = true)
    public void testMobleLocal(String params) {
        String url = Constants.MOBILELOCAL_URL;
        String method =  Constants.METHOD;
        Response response = HttpUtil.call(method, url, params);
        int code = response.code();
        String responsebody = null;
        try {
            responsebody = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("-----TestLogException-----:{}", e.getMessage());
        }
        JSONObject jsonObject1 = JSONObject.parseObject(responsebody);
        String resultcode = (String)jsonObject1.get("resultcode");
        LOGGER.info("responsecode is --->:{}",code);
        LOGGER.info("resultcode is --->:{}",resultcode);
        LOGGER.info("body is --->:{}",responsebody);
        Assert.assertEquals(resultcode, "200", "查询失败！");

    }

    @DataProvider(name = "datas")
    public Object[][] datas() {
        return new Object[][]{
                {"phone=18365264128&dtype=&key=8ce9849c0ce5e665554bc7495c25ec73"},
                {"phone=18365264128&dtype=json&key=8ce9849c0ce5e665554bc7495c25ec73"},
                {"phone=18365264128&dtype=&key=8ce9849c0ce5e665554bc7495c25ec74"},
                {"phone=111&dtype=&key=8ce9849c0ce5e665554bc7495c25ec73"}
        };
    }

}

