package com.ysj.learnnio.demo.httpclient;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientUtil {

    /**
     * 这里用的closeableHttpClient
     * @param url
     * @return
     */
    public static String doGet(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = null;
        if(response!=null){
            entity  = response.getEntity();
        }
        String result = null;
        try {
            result = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
