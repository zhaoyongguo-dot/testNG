package com.okhttp_review;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Objects;

@Slf4j
public class testCase {
    @Test(dataProvider = "data", alwaysRun = true)
    public void test_MobileLocal(String params) {
        Enums.Method get = Enums.Method.get;
        String url = Constant.MOBILE_LOCAL_URL;
        Response response = OkHttpUtil.callMethod(get, url, params);
        log.info("status_code:{}", response.code());

        String responseBody = null;
        try {
            responseBody = Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject object = JSONObject.parseObject(responseBody);
        String resultcode = (String)object.get("resultcode");
        log.info("响应码:{}", resultcode);
        log.info("原 因:{}", object.get("reason"));
        log.info("返回体:{}", responseBody);
        Assert.assertEquals(resultcode, "200", "查询失败!");

    }

    /**
     * 数据驱动
     * @return data
     */
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {"phone=18365264128&dtype=&key=8ce9849c0ce5e665554bc7495c25ec73"},
                {"phone=18365264128&dtype=json&key=8ce9849c0ce5e665554bc7495c25ec73"},
                {"phone=18365264128&dtype=&key=8ce9849c0ce5e665554bc7495c25ec74"},
                {"phone=123456789&dtype=&key=8ce9849c0ce5e665554bc7495c25ec73"}
        };
    }
}
