package com.java.task.java_grade.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class StudentDto {

    private Integer studentNo = 0;
    private String studentName;
    private Integer korean;
    private Integer english;
    private Integer math;
    private Integer history;
    private Integer science;
    private Integer total;
    private double average;
    private Integer rank;


    public StudentDto () {
    }

    public StudentDto (int studentNo, String studentName, Integer korean, Integer english, Integer math, Integer history, Integer science) {
        this.studentNo = ++studentNo;
        this.studentName = studentName;
        this.korean = korean;
        this.english = english;
        this.math = math;
        this.history = history;
        this.science = science;
        total = korean + english + math + history + science;
        average = total/(double)5;
        rank = 1;
    }

    /*@Override
    public String toString() {
        return "StudentDto{" +
                "studentNo=" + studentNo +
                ", studentName='" + studentName + '\'' +
                ", korean=" + korean +
                ", english=" + english +
                ", math=" + math +
                ", history=" + history +
                ", total=" + total +
                ", average=" + average +
                ", rank=" + rank +
                '}';
    }*/


}
