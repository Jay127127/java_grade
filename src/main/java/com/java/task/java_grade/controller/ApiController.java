package com.java.task.java_grade.controller;

import com.java.task.java_grade.entity.StudentDto;
import com.java.task.java_grade.util.RandomStudent;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;


public class ApiController {
    private static final String HOST_URL = "http://localhost:8888/student";

    public static void main(String[] args) throws Exception {

        final String URL = HOST_URL;
        final HttpGet request = new HttpGet(URL);
        final CloseableHttpClient httpClient = HttpClients.createDefault();

        // Apply timeout for the request
        RequestConfig requestConfig = RequestConfig.custom()
                /*.setSocketTimeout(3 * 1000)
                .setConnectTimeout(3 * 1000)
                .setConnectionRequestTimeout(3 * 1000)*/
                .build();
        request.setConfig(requestConfig);

        System.out.println(" 시작 : HttpClient사용 Post방식 Rest API 테스트 -----");
        System.out.println(" 시작 : HttpClient사용 Get 방식 Rest API 테스트 -----");

        //--------------------------------------------------

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            List<StudentDto> studentDtoList = RandomStudent.randomStudent(30);
            String result = EntityUtils.toString((HttpEntity) studentDtoList);
//            String result = EntityUtils.toString(entity);

            System.out.println("\n 결과 :::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println(result);
            System.out.println("결과 :::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");

            String vResponseMessage = "";

            //URI vUri = new URI("https://jsonplaceholder.typicode.com/postsXPXP");
            URI vUri = new URI("https://reqres.in/api/users");

            HttpClient vHttpClient = HttpClientBuilder.create().build();
            HttpPost vHttpPost = new HttpPost(vUri);
            vHttpPost.setHeader("", "");

            vHttpPost.addHeader("", "");

            vHttpPost.setEntity(new StringEntity(vResponseMessage));

            HttpResponse vHttpResponse = vHttpClient.execute(vHttpPost);

            //Response 출력
            if (vHttpResponse.getStatusLine().getStatusCode() == 200) {

                ResponseHandler<String> vResponseHandler = new BasicResponseHandler();
                String vResponse = vResponseHandler.handleResponse(vHttpResponse);

                System.out.println("\n");
                System.out.println("요청 성공");
                System.out.println("\t" + vHttpResponse.getStatusLine().getStatusCode());
                System.out.println("\t" + vHttpResponse.getStatusLine().getReasonPhrase());
                System.out.println("\t" + vResponse);

            } else if (vHttpResponse.getStatusLine().getStatusCode() == 201)  {

                ResponseHandler<String> vResponseHandler = new BasicResponseHandler();
                String vResponse = vResponseHandler.handleResponse(vHttpResponse);

                System.out.println("\n");
                System.out.println("요청 성공");
                System.out.println("\t" + vHttpResponse.getStatusLine().getStatusCode());
                System.out.println("\t" + vHttpResponse.getStatusLine().getReasonPhrase());
                System.out.println("\t" + vResponse);

            } else {

                System.out.println("\n");
                System.out.println("요청 실패");
                System.out.println("\t" + vHttpResponse.getStatusLine().getStatusCode());
                System.out.println("\t" + vHttpResponse.getStatusLine().getReasonPhrase());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex){
            System.out.println(ex.toString());
        }

        //--------------------------------------------------

        System.out.println("\n");
        System.out.println("종료 : HttpClient사용 Post방식 Rest API 테스트 -----");
    }
}





    /*public void get(){
        HttpURLConnection conn = null;
        JSONObject responseJson = null;

        try{
            URL url = new URL(HOST_URL);

            conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");

            JSONObject jsonData = new JSONObject();

            jsonData = responseJson.getJSONObject("StudentList");

            int responseCode = conn.getResponseCode();
            if (responseCode == 400 || responseCode == 401 || responseCode == 500 ) {
                System.out.println(responseCode + " Error!");
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                StringBuilder response = new StringBuilder();
                String responseLine = "";
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine);
                }
                responseJson = new JSONObject(response.toString());
                System.out.println(responseJson);
            }

        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}*/
