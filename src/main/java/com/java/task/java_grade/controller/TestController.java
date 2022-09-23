package com.java.task.java_grade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // TestController라는 클래스가 "컨트롤러"임을 설정하는 어노테이션(@)
public class TestController {

    @GetMapping("/home") // 기본 주소 뒤에 "/home"가 오면 goHome 메서드가 실행됩니다.
    public String goHome(){
        return "home"; // "home"이라는 문자열(String)을 반환하는데,
        // Thymeleaf 템플릿 엔진(build.gradle)을 사용하므로 html 파일을 반환합니다.
        // 즉 home.html 파일을 리턴합니다.
    }
}