package com.lvxus.ipproxy.utils;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class ConnectUtils {
    public static void proxyConnectByHttpClient(String connectUrl,List<String> regexResults) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        for (int i = 0; i < regexResults.size(); i++) {
            HttpHost proxy = new HttpHost(regexResults.get(i), Integer.parseInt(regexResults.get(++i)));
            RequestConfig config = RequestConfig.custom().setProxy(proxy).setConnectTimeout(5000).
                    setSocketTimeout(5000).build();
            HttpGet httpGet = new HttpGet(connectUrl);
            httpGet.setConfig(config);
            try {
                response = httpClient.execute(httpGet);
                System.out.println(EntityUtils.toString(response.getEntity(),"UTF-8"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }

        try {
            if (httpClient != null) httpClient.close();
            if (response != null) response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
