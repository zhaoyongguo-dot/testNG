package com.okhttp;

import com.alibaba.fastjson.JSONObject;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Objects;

public class MobileLocal {

    private final static Logger LOGGER = LoggerFactory.getLogger(MobileLocal.class);
    @Test(dataProvider = "datas", alwaysRun = true)
    public void testMobleLocal(String params) {
        String url = Constants.MOBILELOCAL_URL;
        String method =  Constants.METHOD;
        /**
         * 引用HttpUtil的call方法
         * 执行相应的方法调用
         */
        Response response = HttpUtil.call(method, url, params);
        assert response != null;
        int code = response.code();
        String responsebody = null;
        try {
            responsebody = Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("-----TestLogException-----:{}", e.getMessage());
        }
        JSONObject jsonObject1 = JSONObject.parseObject(responsebody);
        String resultcode = (String)jsonObject1.get("resultcode");
        LOGGER.info("responsecode is --->:{}",code);
        LOGGER.info("resultcode is --->:{}",resultcode);
        LOGGER.info("body is --->:{}",responsebody);
        LOGGER.info("protocol--->:{}", response.protocol());
        LOGGER.info("protocol--->:" + response.protocol());
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

