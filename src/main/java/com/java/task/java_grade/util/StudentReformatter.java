package com.java.task.java_grade.util;

import com.java.task.java_grade.entity.StudentDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.java.task.java_grade.util.ReadCSV.readCSVFile;

public class StudentReformatter {
    public static List<StudentDto> reform (StudentDto studentDto){
        List<StudentDto> updatedStudentList = new ArrayList<>();
        List<StudentDto> studentListCopy = new ArrayList<>();

        // csv 파일 읽기
        String readPath = "C:/Users/Intellivix/Desktop/java_task/new.csv";
        HashMap<String,Object> csvData = readCSVFile(readPath);

        // 타겟 학생의 점수 조작
        for(String key : csvData.keySet()) {
            if (key.contains(studentDto.getTargetStudent())) {
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
            } else { // 그 외 학생 rank 초기화
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
        return updatedStudentList;
    }
}
