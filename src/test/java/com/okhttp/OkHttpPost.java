package com.okhttp;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.util.Objects;

public class OkHttpPost {

    private final static Logger LOGGER = LoggerFactory.getLogger(OkHttpPost.class);
    public static void main(String[] args) {
        String url = "http://apis.juhe.cn/simpleWeather/query";
        OkHttpClient client = new OkHttpClient();
        MediaType type = MediaType.Companion.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.Companion.create("city=上海&key=cd4587926813ec16367deb93688301aa",type);
        Request request = new Request.Builder().url(url).post(body).build();
        try {
            Response response = client.newCall(request).execute();
            LOGGER.info("return code is:{}", response.code());
            LOGGER.info("return body is--->:{}", Objects.requireNonNull(response.body()).string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
