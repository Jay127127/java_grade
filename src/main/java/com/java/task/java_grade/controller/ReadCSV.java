package com.java.task.java_grade.controller;

import com.java.task.java_grade.entity.StudentDto;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReadCSV {
    public static HashMap<String ,Object> readCSVFile(String csvFilePath) {

        HashMap<String, Object> csvData = new HashMap<>();
        List<StudentDto> studentDtoList = new ArrayList<>();
        StudentDto studentDto = new StudentDto();
        String[] columnNames = null;

        BufferedReader bufferedReader = null;

        //File csv = new File("C:/Users/Intellivix/Desktop/java_task/new.csv");

        /*try {
            bufferedReader = Files.newBufferedReader(Paths.get(csvFilePath));
            String line = "";

            List<String> rank = new ArrayList<>();
            List<String> no = new ArrayList<>();
            List<String> name = new ArrayList<>();
            List<String> kor = new ArrayList<>();
            List<String> eng = new ArrayList<>();
            List<String> math = new ArrayList<>();
            List<String> his = new ArrayList<>();
            List<String> sci = new ArrayList<>();
            List<String> tot = new ArrayList<>();
            List<String> avr = new ArrayList<>();


            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArr = line.split(",");

                rank.add(lineArr[0]);
                no.add(lineArr[1]);
                name.add(lineArr[2]);
                kor.add(lineArr[3]);
                eng.add(lineArr[4]);
                math.add(lineArr[5]);
                his.add(lineArr[6]);
                sci.add(lineArr[7]);
                tot.add(lineArr[8]);
                avr.add(lineArr[9]);

            }
            csvData.put("rank",rank);
            csvData.put("no",no);
            csvData.put("name",name);
            csvData.put("kor",kor);
            csvData.put("eng",eng);
            csvData.put("math",math);
            csvData.put("his",his);
            csvData.put("sci",sci);
            csvData.put("tot",tot);
            csvData.put("avr",avr);

        } catch (*/
        try {
            bufferedReader = Files.newBufferedReader(Paths.get(csvFilePath));
            String line = "";

            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {

                // 컬럼이름 추출
                if (i == 0) {
                    columnNames = line.split(",");
                    csvData.put("columnNames", columnNames);
                    continue;
                }

                // 데이터 추출
                String[] tempData = line.split(",");

                studentDto.setRank(Integer.parseInt(tempData[0]));
                studentDto.setStudentNo(Integer.parseInt(tempData[1]));
                studentDto.setStudentName(tempData[2]);
                studentDto.setKorean(Integer.parseInt(tempData[3]));
                studentDto.setEnglish(Integer.parseInt(tempData[4]));
                studentDto.setMath(Integer.parseInt(tempData[5]));
                studentDto.setHistory(Integer.parseInt(tempData[6]));
                studentDto.setScience(Integer.parseInt(tempData[7]));
                studentDto.setTotal(Integer.parseInt(tempData[8]));
                studentDto.setAverage(Integer.parseInt(tempData[9]));
                studentDtoList.add(studentDto);
                ++i;
                continue;
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
        return csvData;
    }
}
