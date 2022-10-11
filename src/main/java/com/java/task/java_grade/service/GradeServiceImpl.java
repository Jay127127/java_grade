package com.java.task.java_grade.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.task.java_grade.controller.RandomStudent;
import com.java.task.java_grade.entity.StudentDto;
import com.java.task.java_grade.mapper.GradeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class GradeServiceImpl implements GradeService {

    private GradeMapper gradeMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public String getGradeDetail() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        List<StudentDto> studentList = RandomStudent.randomStudent(30);
        String jsonInString = null;
        try {
            //Convert object to JSON string
            jsonInString = objectMapper.writeValueAsString(studentList);
            System.out.println(jsonInString);

            //Convert object to JSON string and pretty print
            jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentList);
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
