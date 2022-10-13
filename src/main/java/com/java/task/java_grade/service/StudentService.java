package com.java.task.java_grade.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.java.task.java_grade.util.ResponseVO;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.java.task.java_grade.util.ReadCSV.readCSVFile;

public class StudentService {

    public String getStudentList() throws Exception {
        ResponseVO responseVO = new ResponseVO();

        String readPath = "C:/Users/Intellivix/Desktop/java_task/new.csv";
        HashMap<String,Object> csvData = readCSVFile(readPath);

        String res = "";

        if(csvData != null && csvData.size() > 0){
            ObjectMapper objectMapper = new ObjectMapper();
            res = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(csvData);
        }

        return res;
    }
}
