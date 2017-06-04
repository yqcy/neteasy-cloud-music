package com.yq.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.util.Map;

/**
 * Created by 晴 on 2017/6/4.
 */
public class HttpUtils {

    public static String get(String url, Map<String, String> params) throws IOException {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient httpClient = httpClientBuilder.build();
        HttpGet get = new HttpGet();
        //request参数拼接
        StringBuilder sb = new StringBuilder(url);
        if (params != null && params.size() > 0) {
            sb.append("?");
            for (String s : params.keySet()) {
                sb.append(s);
                sb.append("=");
                sb.append(params.get(s));
                sb.append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
//        get.setURI(URI.create("http://music.163.com/song?id=66842"));
        get.setURI(URI.create(sb.toString()));
        CloseableHttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        if (entity.isStreaming()) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            entity.writeTo(out);
            byte[] bytes = out.toByteArray();
            String s = new String(bytes);
            return s;
        }
        httpClient.close();
        return null;
    }

}
