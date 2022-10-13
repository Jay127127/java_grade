/*
package com.java.task.java_grade.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.task.java_grade.entity.StudentDto;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ConnectionController {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://example.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        //setting request header
        con.setRequestProperty("Content-Type", "application/json");
        String contentType = con.getHeaderField("Content-Type");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setInstanceFollowRedirects(false);
        con.setFollowRedirects(false);

        //setting cookie header
        Map<String, String> parameters = new HashMap<>();
        parameters.put("param1", "val");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        try{
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
*/
