package com.java.task.java_grade.controller;

import com.java.task.java_grade.entity.StudentDto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static com.java.task.java_grade.controller.ReadCSV.readCSVFile;

public class app02 {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int n;

        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("확인할 학생 수를 입력하시오 >> ");
            n = scanner.nextInt();

            List<StudentDto> studentDtoList = new ArrayList<>();

            for (int i = 0; i < n; ++i) {
                int studentNo = n++;
                String name = RandomDataUtil.randomKoreanFullName(1, 2);
                int kor = random.nextInt(100);
                int eng = random.nextInt(100);
                int math = random.nextInt(100);
                int his = random.nextInt(100);
                int sci = random.nextInt(100);

                StudentDto student = new StudentDto(studentNo, name, kor, eng, math, his, sci);
                studentDtoList.add(student);
            }

            for(StudentDto studentDto : studentDtoList){
                System.out.println(studentDto);
            }

            ExportCSV exportCSV = new ExportCSV();
            String exportPath = "C:/Users/Intellivix/Desktop/java_task/2new2.csv";
            exportCSV.exportStudent(studentDtoList, exportPath);


            String readPath = "C:/Users/Intellivix/Desktop/java_task/2new2.csv";
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

            System.out.println("검색할 이름을 입력 :: ");
            String nameInput = scanner.next();

            List<StudentDto> searchedList = new ArrayList<>();

            if(csvData.containsKey(nameInput)){
                StudentDto searched = (StudentDto) csvData.get(nameInput);
                searchedList.add(searched);
            };

            for(StudentDto s: searchedList){
                System.out.println(s);
            }



        }


    }
}
