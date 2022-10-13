package com.java.task.java_grade.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class ApacheHttpClient {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        try (CloseableHttpClient client = HttpClients.createDefault()) {

            HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");

            APOD response = client.execute(request, httpResponse ->
                    mapper.readValue(httpResponse.getEntity().getContent(), APOD.class));

            System.out.println(response.title);
        }

    }

}