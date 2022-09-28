package com.java.task.java_grade.controller;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

import com.java.task.java_grade.entity.LicenseDetailExport;
import com.java.task.java_grade.entity.StudentDto;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.store.Path;

public class app {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int n;

        Scanner scanner = new Scanner(System.in);
        System.out.print("확인할 학생 수를 입력하시오 >> ");
        n = scanner.nextInt();

        List<StudentDto> studentDtoList = new ArrayList<>();
        List<StudentDto> studentListCopy = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int studentNo = i;
            String name = RandomDataUtil.randomKoreanFullName(1, 2);
            int kor = random.nextInt(100);
            int eng = random.nextInt(100);
            int math = random.nextInt(100);
            int his = random.nextInt(100);
            int sci = random.nextInt(100);

            StudentDto student = new StudentDto(studentNo, name, kor, eng, math, his, sci);
            studentDtoList.add(student);
        }

        // 등수 입력
        for (int i = 0; i < studentDtoList.size(); i++) {
            for(int j = 0; j< studentDtoList.size(); j++){
                if (studentDtoList.get(i).getTotal() < studentDtoList.get(j).getTotal()) {
                    int rankTemp = studentDtoList.get(i).getRank();
                    studentDtoList.get(i).setRank(rankTemp+1);
                }
            }
        }

        // 학생 객체 배열 복사
        studentListCopy.addAll(studentDtoList);

        // 등수 순으로 재배열
        for (StudentDto student : studentListCopy){
            int rank = student.getRank();
            studentDtoList.set(rank-1, student);
        }

        // 학생 리스트 출력
        for (StudentDto student : studentDtoList) {
            System.out.println(student);
        }
        //---------------------------------csv 파일 내보내기-------------------------------------------------------------//

        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = Files.newBufferedWriter(Paths.get("C:/Users/Intellivix/Desktop/java_task/new.csv"));

            bufferedWriter.write("등수 | 학생번호 | 학생 이름 | 국어 | 영어 | 수학 | 사회 | 과학 | 총점 | 평균");
            bufferedWriter.newLine();

            for(StudentDto student : studentDtoList){
                StudentDto data = student;
                String aData = "";
                aData = data.getRank() + "|" + data.getStudentNo() + "|" + data.getStudentName() + "|"
                        + data.getKorean() + "|" + data.getEnglish() + "|" + data.getMath() + "|" + data.getHistory() + "|"
                        + data.getScience() + "|" + data.getTotal() + "|" + data.getAverage();

                /*List<String> list = Collections.singletonList(student.toString());
                for(String data : list){
                    bufferedWriter.write(data);
                    bufferedWriter.write(",");
                }*/
                //추가하기
                bufferedWriter.write(aData);
                bufferedWriter.newLine();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(bufferedWriter != null){
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
        }catch(IOException e){
            e.printStackTrace();
        }
    }


//      ================================ 읽어서 다시쓰기 ==================================================================

        BufferedReader bufferedReader = null;

        //csv파일 읽기
        CSVReader csvReader = new CSVReader(bufferedReader);
        csvReader.readAll();

        List<List<String>> csvList = new ArrayList<>();
        File csv = new File("C:/Users/Intellivix/Desktop/java_task/new.csv");
        String line = "";

        try{
            bufferedReader = new BufferedReader(new FileReader(csv));
            while ((line = bufferedReader.readLine()) != null){
                List<String> aLine = new ArrayList<String>();
                String[] lineArr = line.split("|");
                aLine = Arrays.asList(lineArr);
                csvList.add(aLine);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


//      ================================ 읽어서 다시쓰기 ==================================================================
        /*try {
            File location = new File("C:/Users/Intellivix/Desktop/java_task");
            String excelFileName = "학생 점수 상세 [" + studentDtoList.size() + "명] " + LocalDate.now() +"";
            String excelFileFullPath = location + "/" + excelFileName+ ".xlsx";

            LicenseDetailExport export = new LicenseDetailExport();
            XSSFWorkbook workbook = export.generate(studentDtoList);

            FileOutputStream fileOutputStream = new FileOutputStream(excelFileFullPath);
            workbook.write(fileOutputStream);

            workbook.close();
            fileOutputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
    }
}

