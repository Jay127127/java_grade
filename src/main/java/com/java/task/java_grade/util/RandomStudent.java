package com.java.task.java_grade.util;

import com.java.task.java_grade.entity.StudentDto;
import com.java.task.java_grade.util.RandomDataUtil;

import java.util.*;

public class RandomStudent {
    public static List<StudentDto> randomStudent(int stuNo) throws Exception {
        Random random = new Random();
        int n = stuNo;

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

        // 학생 리스트 콘솔 출력
        for (StudentDto student : studentDtoList) {
            System.out.println(student);
        }
        return studentDtoList;
    }
}
