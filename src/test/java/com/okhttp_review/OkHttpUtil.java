package com.okhttp_review;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

@Slf4j
public class OkHttpUtil {

    /**
     * call方法
     */
    public static Response callMethod(Enums.Method method, String url, String params) {
        Response response = null;
        switch (method) {
            case get:
                response = getMethod(url, params);
                break;
            case post:
                response =  postMethod(url, params);
                break;
            case put:
                response = putMethod(url, params);
                break;
            case delete:
                response = deleteMethod(url, params);
                break;
            default:
                log.info("没找到可执行的方法");
        }
        return response;
    }

    /**
     * get请求
     * @param url url
     * @param params params
     * @return response
     */
    public static Response getMethod(String url, String params) {

        /*
         * 创建客户端 + 请求
         */
        OkHttpClient client = new OkHttpClient();
        Request request = new Request
                .Builder()
                .url(url + "?" + params)
                .get()
                .build();
        try {
            /*
             * 执行请求 + 相应结果
             */
            return client.newCall(request).execute();
        } catch (IOException e) {
            log.info("发起get请求异常:{}", e.getMessage());
        }
        return null;
    }

    /**
     * post请求
     * @param url url
     * @param params params
     * @return response
     */
    public static Response postMethod(String url, String params) {
        /*
         * 创建客户端 + mediaType + body
         */
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.Companion.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.Companion.create(params, mediaType);
        Request request = new Request
                .Builder()
                .url(url)
                .post(body)
                .build();
        /*
         * 执行请求并返回结果
         */
        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            log.info("message{}", e.getMessage());
        }
        return null;
    }

    /**
     * put
     */
    public static Response putMethod(String url, String params) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.Companion.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.Companion.create(params, mediaType);
        Request request = new Request
                .Builder()
                .url(url)
                .put(body)
                .build();
        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            log.info("message{}", e.getMessage());
        }
        return null;
    }

    /**
     * delete
     */
    public static Response deleteMethod(String url, String params) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.Companion.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.Companion.create(params, mediaType);
        Request request = new Request
                .Builder()
                .url(url)
                .delete(body)
                .build();
        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        return null;
    }
}

