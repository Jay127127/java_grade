package com.java.task.java_grade.controller;

import com.java.task.java_grade.entity.StudentDto;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReadCSV {
    public static HashMap<String ,Object> readCSVFile(String readPath) {

        /*HashMap<String, Object> csvData = new HashMap<>();
        List<StudentDto> studentDtoList = new ArrayList<>();

        String[] columnNames = null;

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = Files.newBufferedReader(Paths.get(readPath), StandardCharsets.UTF_8);
            String line = "";

            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {

                // 컬럼이름 추출
                if (i == 0) {
                    columnNames = line.split(",");
                    csvData.put("columnNames", columnNames);
                    i++;
                    continue;
                }

                // 데이터 추출
                String[] tempData = line.split(",");
                StudentDto studentDto = new StudentDto();
                studentDto.setRank(Integer.parseInt(tempData[0]));
                studentDto.setStudentNo(Integer.parseInt(tempData[1]));
                studentDto.setStudentName(tempData[2]);
                studentDto.setKorean(Integer.parseInt(tempData[3]));
                studentDto.setEnglish(Integer.parseInt(tempData[4]));
                studentDto.setMath(Integer.parseInt(tempData[5]));
                studentDto.setHistory(Integer.parseInt(tempData[6]));
                studentDto.setScience(Integer.parseInt(tempData[7]));
                studentDto.setTotal(Integer.parseInt(tempData[8]));
                studentDto.setAverage(Double.parseDouble(tempData[9]));
                studentDtoList.add(studentDto);
            }

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        csvData.put("studentDtoList", studentDtoList);
        csvData.put("columnNames", columnNames);
        return csvData;*/



        BufferedReader bufferedReader = null;

        HashMap<String, Object> csvData = new HashMap<>();

        try {
            bufferedReader = Files.newBufferedReader(Paths.get(readPath), StandardCharsets.UTF_8);
            String line = "";


            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {

                // 컬럼이름 추출
                if (i == 0) {
                    String[] columnNames = line.split(",");
                    csvData.put("columnNames", columnNames);
                    i++;
                    continue;
                }
                // 데이터 추출
                String[] tempData = line.split(",");
                StudentDto studentDto = new StudentDto();
                String keyName = tempData[2];
                studentDto.setRank(Integer.parseInt(tempData[0]));
                studentDto.setStudentNo(Integer.parseInt(tempData[1]));
                studentDto.setStudentName(tempData[2]);
                studentDto.setKorean(Integer.parseInt(tempData[3]));
                studentDto.setEnglish(Integer.parseInt(tempData[4]));
                studentDto.setMath(Integer.parseInt(tempData[5]));
                studentDto.setHistory(Integer.parseInt(tempData[6]));
                studentDto.setScience(Integer.parseInt(tempData[7]));
                studentDto.setTotal(Integer.parseInt(tempData[8]));
                studentDto.setAverage(Double.parseDouble(tempData[9]));
                csvData.put(keyName, studentDto);
            }

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvData;

    }
}