package com.okhttp;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.util.Objects;

@Slf4j
public class OkHttpGet {

    // private final static Logger LOGGER = LoggerFactory.getLogger(OkHttpGet.class);
    public static void main(String[] args) {
        get_case01();
    }

    private static void get_case01() {
        String url = "http://apis.juhe.cn/mobile/get";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url + "?" + "phone=18365264128&dtype=&key=8ce9849c0ce5e665554bc7495c25ec73").get().build();
        try {
            Response response = client.newCall(request).execute();
            log.info("return code is--->:{}", response.code());
            log.info("return body is--->:{}", Objects.requireNonNull(response.body()).string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
