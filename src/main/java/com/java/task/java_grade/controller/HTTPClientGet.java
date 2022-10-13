package com.java.task.java_grade.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HTTPClientGet {

    public static void main(String[] args) throws IOException {
        getStudents();
        getStudentsByName();
    }

    private static void getStudents() throws ClientProtocolException, IOException {
        RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(3000)
				.setConnectionRequestTimeout(3000)
				.setSocketTimeout(30000)
                .build();

        try (CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build()) {

            //HTTP GET method
            HttpGet httpget = new HttpGet("http://localhost:8888/home");
            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            HttpResponse httpResponse = httpclient.execute(httpget);
            httpResponse.getStatusLine();
            httpResponse.getEntity();

            ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }

    private static void getStudentsByName() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            //HTTP GET method
            HttpGet httpget = new HttpGet("http://localhost:8888/home");
            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler < String > responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }
}