package com.java.task.java_grade.controller;

import com.java.task.java_grade.entity.StudentDto;

import java.util.*;

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
                String name = RandomDataUtil.randomKoreanFullName(1, 2);
                int kor = random.nextInt(100);
                int eng = random.nextInt(100);
                int math = random.nextInt(100);
                int his = random.nextInt(100);

                StudentDto student = new StudentDto(name, kor, eng, math, his);
                studentDtoList.add(student);
            }

            for(StudentDto studentDto : studentDtoList){
                System.out.println(studentDto);
            }
        }


    }
}
