//package com.java.task.java_grade.controller;
//
//import com.fasterxml.jackson.core.JsonGenerationException;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.exc.StreamWriteException;
//import com.fasterxml.jackson.databind.DatabindException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.java.task.java_grade.entity.StudentDto;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.*;
//import java.util.List;
//
//public class ConnectionController {
//    public static void main(String[] args) throws Exception {
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Content-type", "application/json");
//        conn.setDoOutput(true);
//
//        try{
//            StringBuffer sb = new StringBuffer();
//            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
//            while(br.ready()) {
//                sb.append(br.readLine());
//            }
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//        String hostname = "127.0.0.1";
//        int port = 1234;
//        int timeout = 3000;
//        SocketAddress socketAddress = new InetSocketAddress(hostname, port);
//        Socket socket = new Socket();
//        try {
//            socket.setSoTimeout(timeout);			/* InputStream에서 데이터읽을때의 timeout */
//            socket.connect(socketAddress, timeout);	/* socket연결 자체에대한 timeout */
//        } catch (SocketException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                socket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        List<StudentDto> studentList = RandomStudent.randomStudent(30);
//        try {
//            //Convert object to JSON string
//            String jsonInString = objectMapper.writeValueAsString(studentList);
//            System.out.println(jsonInString);
//
//            //Convert object to JSON string and pretty print
//            jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentList);
//            System.out.println(jsonInString);
//
//        } catch (JsonGenerationException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
