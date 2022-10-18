package com.java.task.java_grade.service;

import com.java.task.java_grade.entity.StudentDto;
import com.java.task.java_grade.util.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static com.java.task.java_grade.util.ReadCSV.readCSVFile;

public class StudentService {

    public ResponseVO getStudentList() throws Exception {
        ResponseVO responseVO = new ResponseVO();

        // csv 파일 읽기
        String readPath = "C:/Users/Intellivix/Desktop/java_task/new.csv";
        HashMap<String,Object> csvData = readCSVFile(readPath);

        // 결과
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
        // 랜덤 학생 리스트 생성
        List<StudentDto> studentDtoList = StudentGenerator.generate(studentDto.getCreateStudentNo());

        // 결과
        if(studentDtoList != null && studentDtoList.size() > 0){

            // csv 파일 저장
            ExportCSV exportCSV = new ExportCSV();
            String exportPath = "C:/Users/Intellivix/Desktop/java_task/new.csv";
            exportCSV.exportStudent(studentDtoList, exportPath);

            responseVO.setResult(studentDtoList);
            responseVO._setPOMErrorCode(POMErrorCode.P_200);
        }else{
            responseVO._setPOMErrorCode(POMErrorCode.P_4001);
        }
        return responseVO;
    }

    public ResponseVO uppdateStudentList(StudentDto studentDto) throws Exception {
        ResponseVO responseVO = new ResponseVO();
        // 조작된 학생 리스트 생성
        List<StudentDto> updatedStudentList = StudentReformatter.reform(studentDto);

        // 결과
        if(updatedStudentList != null && updatedStudentList.size() > 0){

            // csv 파일 저장
            ExportCSV exportCSV = new ExportCSV();
            String exportPath = "C:/Users/Intellivix/Desktop/java_task/new.csv";
            exportCSV.exportStudent(updatedStudentList, exportPath);

            responseVO.setResult(updatedStudentList);
            responseVO._setPOMErrorCode(POMErrorCode.P_200);
        }else{
            responseVO._setPOMErrorCode(POMErrorCode.P_4001);
        }
        return responseVO;
    }
}
