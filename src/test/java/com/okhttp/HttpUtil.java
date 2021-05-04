package com.okhttp;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);
    // get Method
    public static Response get(String url, String params) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request
                .Builder()
                .url(url + "?" + params)
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("response err:{}", e.getMessage());
        }
        return null;
    }

    // post Method
    public static Response post(String url, String params) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaTypetype = MediaType.Companion.parse("application/x-www-form-urlencoded");
        RequestBody requestBodybody = RequestBody.Companion.create(params, mediaTypetype);
        Request request = new Request
                .Builder()
                .url(url)
                .post(requestBodybody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("response err:{}", e.getMessage());
        }
        return null;
    }

    // put Method
    public static Response put(String url, String params) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaTypetype = MediaType.Companion.parse("application/x-www-form-urlencoded");
        RequestBody requestBodybody = RequestBody.Companion.create(params, mediaTypetype);
        Request request = new Request
                .Builder()
                .url(url)
                .put(requestBodybody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("response err:{}", e.getMessage());
        }
        return null;
    }

    // delete Method
    public static Response delete(String url, String params) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.Companion.parse("application/x-www-form-urlencoded");
        RequestBody requestBody = RequestBody.Companion.create(params, mediaType);
        Request request = new Request
                .Builder()
                .url(url)
                .delete(requestBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("response err:{}", e.getMessage());
        }
        return null;
    }

    // call Method
    public static Response call(String method, String url, String params) {
        if("get".equalsIgnoreCase(method)) {
            return get(url, params);
        } else if ("post".equalsIgnoreCase(method)) {
            return post(url, params);
        } else if ("put".equalsIgnoreCase(method)) {
            return put(url, params);
        } else if ("delete".equalsIgnoreCase(method)) {
            return delete(url, params);
        }
        return null;
    }
}
