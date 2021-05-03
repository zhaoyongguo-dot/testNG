package com.okhttp;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);
    // get Method
    public static Response get(String url, String param) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request
                .Builder()
                .url(url + "?" + param)
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // post Method
    public static Response post(String url, String param) {
        OkHttpClient client = new OkHttpClient();
        MediaType type = MediaType.Companion.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.Companion.create(param, type);
        Request request = new Request
                .Builder()
                .url(url)
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // call Method
    public static Response call(String method, String url, String param) {
        if("get".equalsIgnoreCase(method)) {
            return get(url, param);
        } else if ("post".equalsIgnoreCase(method)) {
            return post(url, param);
        }
        return null;
    }
}
