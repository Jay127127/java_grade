package com.java.task.java_grade.controller;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.task.java_grade.entity.LicenseDetailExport;
import com.java.task.java_grade.entity.StudentDto;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class app {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int n;

        Scanner scanner = new Scanner(System.in);
        System.out.print("확인할 학생 수를 입력하시오 >> ");
        n = scanner.nextInt();

        List<StudentDto> studentDtoList = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            String name = RandomDataUtil.randomKoreanFullName(1, 2);
            int kor = random.nextInt(100);
            int eng = random.nextInt(100);
            int math = random.nextInt(100);
            int his = random.nextInt(100);

            StudentDto student = new StudentDto(name, kor, eng, math, his);
            studentDtoList.add(student);
        }
        for (StudentDto student : studentDtoList) {
            System.out.println(student);
        }
        //---------------------------------csv 파일 내보내기-------------------------------------------------------------//

        try {
            File location = new File("C:/Users/Intellivix/Desktop/java_task");
            String excelFileName = "학생 점수 상세 [" + studentDtoList.size() + "명]";
            String excelFileFullPath = location + "/" + excelFileName+ ".xlsx";

            LicenseDetailExport export = new LicenseDetailExport();
            XSSFWorkbook workbook = export.generate(studentDtoList);

            FileOutputStream fileOutputStream = new FileOutputStream(excelFileFullPath);
            workbook.write(fileOutputStream);

            workbook.close();
            fileOutputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

          // 학생 수 만큼의 학생들의 배열 생성
//        StudentDto[] students = new StudentDto[n];
//        for (int i = 0; i < students.length; ++i) {
//            students[i] = new StudentDto();
//        }
//
//        // 각각의 학생들의 이름과 성적을 각 배열에 저장
//        for (int i = 0; i < n; ++i) {
//            String name = RandomDataUtil.randomKoreanFullName(1,2);
//            int kor = random.nextInt(100);
//            int eng = random.nextInt(100);
//            int math = random.nextInt(100);
//            int his = random.nextInt(100);
//
//            students[i].setStudentName(name);
//            students[i].setKorean(kor);
//            students[i].setEnglish(eng);
//            students[i].setMath(math);
//            students[i].setHistory(his);
//        }
//
//        // 입력 받은 정보들을 출력
//        for (StudentDto student : students) {
//            System.out.println(student.toString());
//            System.out.println(student.getClass());
//        }

            /*List<Integer> totalList = new ArrayList<>();
                    for(StudentDto students : studentDtoList){
                int total = students.getTotal();
                totalList.add(total);
            }

                    for(StudentDto students : studentDtoList){
                for (int k = 0; k<n; k++) {
                    for(int j=0; j<studentDtoList.size(); j++) {
                        if(totalList.get(k) < totalList.get(j)) {
                            // 총점이 다음 사람보다 적으면 내 등수가 1++
                            int rank = student.getRank();
                            students.setRank(rank++);
                        }
                    }
                }
            }*/
}

