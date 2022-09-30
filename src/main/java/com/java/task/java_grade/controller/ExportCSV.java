package com.java.task.java_grade.controller;

import com.java.task.java_grade.entity.StudentDto;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ExportCSV {

    public void exportStudent(List<StudentDto> studentDtoList){

        BufferedWriter bufferedWriter = null;
        //TODO : UTF-8 설정
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
    }
}
