package com.java.task.java_grade.controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.java.task.java_grade.entity.StudentDto;

import static com.java.task.java_grade.controller.ReadCSV.readCSVFile;

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
            int kor = (int)(Math.random() * 100);
            int eng = (int)(Math.random() * 100);
            int math = (int)(Math.random() * 100);
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
        ExportCSV exportCSV = new ExportCSV();
        exportCSV.exportStudent(studentDtoList);

        /*
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = Files.newBufferedWriter(Paths.get("C:/Users/Intellivix/Desktop/java_task/new.csv"));

            bufferedWriter.write("등수,학생번호,학생이름,국어,영어,수학,사회,과학,총점,평균");
            bufferedWriter.newLine();

            for(StudentDto student : studentDtoList){
                StudentDto data = student;
                String aData = "";
                aData = data.getRank() + "," + data.getStudentNo() + "," + data.getStudentName() + ","
                        + data.getKorean() + "," + data.getEnglish() + "," + data.getMath() + "," + data.getHistory() + ","
                        + data.getScience() + "," + data.getTotal() + "," + data.getAverage();

                *//*List<String> list = Collections.singletonList(student.toString());
                for(String data : list){
                    bufferedWriter.write(data);
                    bufferedWriter.write(",");
                }*//*
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
        */

//      ================================ csv 파일 읽어오기 ==================================================================
        String csvFilePath = "C:/Users/Intellivix/Desktop/java_task/new.csv";
        HashMap<String,Object> csvData = readCSVFile(csvFilePath);

        System.out.println("cvsData ::: " +csvData);

        /*ArrayList rankList = new ArrayList();
        ArrayList sNoList = new ArrayList();
        ArrayList sNameList = new ArrayList();
        ArrayList korList = new ArrayList();
        ArrayList engList = new ArrayList();
        ArrayList mathList = new ArrayList();
        ArrayList hisList = new ArrayList();
        ArrayList sciList = new ArrayList();
        ArrayList totalList = new ArrayList();
        ArrayList avrList = new ArrayList();

        HashMap studentMap = new HashMap();
        for(List aList : studentList){
            String rank = (String)aList.get(0);  rankList.add(rank);
            String sNo = (String)aList.get(1);   sNoList.add(sNo);
            String sName = (String)aList.get(2); sNameList.add(sName);
            String kor = (String)aList.get(3);   korList.add(kor);
            String eng = (String)aList.get(4);   engList.add(eng);
            String math = (String)aList.get(5);  mathList.add(math);
            String his = (String)aList.get(6);   hisList.add(his);
            String sci = (String)aList.get(7);   sciList.add(sci);
            String total = (String)aList.get(8); totalList.add(total);
            String avr = (String)aList.get(9);   avrList.add(avr);
        }
        studentMap.put("등수", rankList);
        studentMap.put("학생번호", sNoList);
        studentMap.put("학생이름", sNameList);
        studentMap.put("국어", korList);
        studentMap.put("영어", engList);
        studentMap.put("수학", mathList);
        studentMap.put("사회", hisList);
        studentMap.put("과학", sciList);
        studentMap.put("총점", totalList);
        studentMap.put("평균", avrList);*/


//      ================================ 검색 기능 만들기 ==================================================================
        System.out.println("검색할 이름을 입력 :: ");
        String nameInput = scanner.next();

        List<StudentDto> searchedStudentList = new ArrayList<>();
        List<StudentDto> studentDtoListRead = (List<StudentDto>) csvData.get("studentDtoList");

        for (StudentDto studentDto : studentDtoListRead) {
            if (studentDto.getStudentName().contains(nameInput)) {
                searchedStudentList.add(studentDto);
            }
        }


        //System.out.println("studentMap ::: " + studentMap);
        //System.out.println("studentData ::: " + studentData);


//      ================================ 엑셀파일로 내보내기 ==================================================================
        exportCSV.exportStudent(searchedStudentList);

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

