package com.java.task.java_grade.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

import static com.java.task.java_grade.util.ReadCSV.readCSVFile;

@Slf4j
@Service
public class GradeService {



    public String getGradeDetail() throws Exception {
        String readPath = "C:/Users/Intellivix/Desktop/java_task/new.csv";
        HashMap<String,Object> csvData = readCSVFile(readPath);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInString = null;
        try {
            //Convert object to JSON string
            jsonInString = objectMapper.writeValueAsString(csvData);
            System.out.println(jsonInString);

            //Convert object to JSON string and pretty print
            jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(csvData);
            System.out.println(jsonInString);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonInString;
    }
}
