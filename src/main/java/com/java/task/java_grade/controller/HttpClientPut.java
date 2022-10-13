package com.java.task.java_grade.controller;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientPut {

    public static void main(String[] args) throws IOException {
        putUser();
    }

    public static void putUser() throws IOException {
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(3000)
                .setConnectionRequestTimeout(3000)
                .setSocketTimeout(30000)
                .build();

        try (CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build()) {
            HttpPut httpPut = new HttpPut("http://localhost:8090/api/pom/v1/data/group/gps/add");
            httpPut.setHeader("Accept", "application/json");
            httpPut.setHeader("Content-type", "application/json");
            httpPut.setHeader("CLIENT-TYPE", "CLIENT");
            httpPut.setHeader("DIVA-AUTH", "IVX-1234567890");
            String json = "{\r\n" + "  \"firstName\": \"Ram\",\r\n" + "  \"lastName\": \"Jadhav\",\r\n" +
                    "  \"emailId\": \"ramesh1234@gmail.com\",\r\n" +
                    "  \"createdAt\": \"2018-09-11T11:19:56.000+0000\",\r\n" + "  \"createdBy\": \"Ramesh\",\r\n" +
                    "  \"updatedAt\": \"2018-09-11T11:26:31.000+0000\",\r\n" + "  \"updatedby\": \"Ramesh\"\r\n" +
                    "}";
            StringEntity stringEntity = new StringEntity(json);
            httpPut.setEntity(stringEntity);

            System.out.println("Executing request " + httpPut.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
            };
            String responseBody = httpclient.execute(httpPut, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }
}
