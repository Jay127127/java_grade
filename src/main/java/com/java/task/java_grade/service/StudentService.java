package com.java.task.java_grade.service;

import com.java.task.java_grade.entity.StudentDto;
import com.java.task.java_grade.util.ExportCSV;
import com.java.task.java_grade.util.POMErrorCode;
import com.java.task.java_grade.util.RandomDataUtil;
import com.java.task.java_grade.util.ResponseVO;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static com.java.task.java_grade.util.ReadCSV.readCSVFile;

public class StudentService {

    public ResponseVO getStudentList() throws Exception {
        ResponseVO responseVO = new ResponseVO();

        // 기록 리스트 가져오기
        String readPath = "C:/Users/Intellivix/Desktop/java_task/new.csv";
        HashMap<String,Object> csvData = readCSVFile(readPath);

        if(csvData != null){
            responseVO.setResult(csvData);
            responseVO._setPOMErrorCode(POMErrorCode.P_200);
        }else{
            responseVO._setPOMErrorCode(POMErrorCode.P_4001);
        }
        return responseVO;
    }

    public ResponseVO insertStudent(StudentDto studentDto) throws Exception {
        ResponseVO responseVO = new ResponseVO();
        int createStudentNo= studentDto.getCreateStudentNo();

        Random random = new Random();
        List<StudentDto> studentDtoList = new ArrayList<>();
        List<StudentDto> studentListCopy = new ArrayList<>();

        for (int i = 0; i < createStudentNo; ++i) {
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
        //================================ csv 파일 내보내기 =============================================================
        ExportCSV exportCSV = new ExportCSV();
        String exportPath = "C:/Users/Intellivix/Desktop/java_task/new.csv";
        exportCSV.exportStudent(studentDtoList, exportPath);

        if(studentDtoList != null && studentDtoList.size() > 0){
            responseVO.setResult(studentDtoList);
            responseVO._setPOMErrorCode(POMErrorCode.P_200);
        }else{
            responseVO._setPOMErrorCode(POMErrorCode.P_4001);
        }
        return responseVO;
    }

    public ResponseVO uppdateStudentList(StudentDto studentDto) throws Exception {
        ResponseVO responseVO = new ResponseVO();

        // 기록 리스트 가져오기
        String readPath = "C:/Users/Intellivix/Desktop/java_task/new.csv";
        HashMap<String,Object> csvData = readCSVFile(readPath);

        String targetStudent = studentDto.getTargetStudent();
        List<StudentDto> updatedStudentList = new ArrayList<>();
        List<StudentDto> studentListCopy = new ArrayList<>();

        for(String key : csvData.keySet()) {
            if (key.contains(targetStudent)) {
                StudentDto tStudent = (StudentDto) csvData.get(key);
                tStudent.setStudentNo(((StudentDto) csvData.get(key)).getStudentNo());
                tStudent.setStudentName(((StudentDto) csvData.get(key)).getStudentName());
                tStudent.setKorean(studentDto.getKorean());
                tStudent.setEnglish(studentDto.getEnglish());
                tStudent.setMath(studentDto.getMath());
                tStudent.setHistory(studentDto.getHistory());
                tStudent.setScience(studentDto.getScience());
                tStudent.setTotal(studentDto.getTotal());
                tStudent.setAverage(studentDto.getAverage());
                tStudent.setRank(1);
                updatedStudentList.add(tStudent);
            } else {
                StudentDto tStudent = (StudentDto) csvData.get(key);
                tStudent.setRank(1);
                updatedStudentList.add(tStudent);
            }
        }

        // 등수 입력
        for (int i = 0; i < updatedStudentList.size(); i++) {
            for(int j = 0; j< updatedStudentList.size(); j++){
                if (updatedStudentList.get(i).getTotal() < updatedStudentList.get(j).getTotal()) {
                    int rankTemp = updatedStudentList.get(i).getRank();
                    updatedStudentList.get(i).setRank(rankTemp+1);
                }
            }
        }

        // 학생 객체 배열 복사
        studentListCopy.addAll(updatedStudentList);

        // 등수 순으로 재배열
        for (StudentDto student : studentListCopy){
            int rank = student.getRank();
            updatedStudentList.set(rank-1, student);
        }


        //================================ csv 파일 내보내기 ==================================================================
        ExportCSV exportCSV = new ExportCSV();
        String exportPath = "C:/Users/Intellivix/Desktop/java_task/new.csv";
        exportCSV.exportStudent(updatedStudentList, exportPath);


        if(updatedStudentList != null && updatedStudentList.size() > 0){
            responseVO.setResult(updatedStudentList);
            responseVO._setPOMErrorCode(POMErrorCode.P_200);
        }else{
            responseVO._setPOMErrorCode(POMErrorCode.P_4001);
        }
        return responseVO;
    }
}
