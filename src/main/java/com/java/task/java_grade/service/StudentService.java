package com.java.task.java_grade.service;

import com.java.task.java_grade.entity.StudentDto;
import com.java.task.java_grade.util.POMErrorCode;
import com.java.task.java_grade.util.ResponseVO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.java.task.java_grade.util.ReadCSV.readCSVFile;

public class StudentService {

    /*public String getStudentList() throws Exception {
        ResponseVO responseVO = new ResponseVO();

        String readPath = "C:/Users/Intellivix/Desktop/java_task/new.csv";
        HashMap<String,Object> csvData = readCSVFile(readPath);

        String res = "";

        if(csvData != null && csvData.size() > 0){
            ObjectMapper objectMapper = new ObjectMapper();
            res = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(csvData);
        }

        return res;
    }*/

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

    public ResponseVO putStudentList(HttpServletRequest request) throws Exception {
        ResponseVO responseVO = new ResponseVO();

        // 기록 리스트 가져오기
        String readPath = "C:/Users/Intellivix/Desktop/java_task/new.csv";
        HashMap<String,Object> csvData = readCSVFile(readPath);

        List<StudentDto> updatedStudentList = new ArrayList<>();

        String studentName = request.getParameter("studentName");
        String changeName = request.getParameter("changeName");
        int korean = Integer.parseInt(request.getParameter("korean"));
        int english = Integer.parseInt(request.getParameter("english"));
        int math = Integer.parseInt(request.getParameter("math"));
        int history = Integer.parseInt(request.getParameter("history"));
        int science = Integer.parseInt(request.getParameter("science"));
        int total = korean+english+math+history+science;
        double average = (double) total/5;

        for(String key : csvData.keySet()){
            if(key.contains(studentName)){
                StudentDto targetStudent= (StudentDto) csvData.get(key);
                targetStudent.setStudentName(changeName);
                targetStudent.setKorean(korean);
                targetStudent.setEnglish(english);
                targetStudent.setMath(math);
                targetStudent.setHistory(history);
                targetStudent.setScience(science);
                targetStudent.setTotal(total);
                targetStudent.setAverage(average);
                updatedStudentList.add((StudentDto) csvData.get(key));
            }else{
                updatedStudentList.add((StudentDto) csvData.get(key));
            }
        }

        if(updatedStudentList != null){
            responseVO.setResult(updatedStudentList);
            responseVO._setPOMErrorCode(POMErrorCode.P_200);
        }else{
            responseVO._setPOMErrorCode(POMErrorCode.P_4001);
        }
        return responseVO;
    }
}
