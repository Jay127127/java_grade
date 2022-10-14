package com.java.task.java_grade.controller;

import com.java.task.java_grade.service.StudentService;
import com.java.task.java_grade.util.POMErrorCode;
import com.java.task.java_grade.util.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@RestController
@RequestMapping("/student")
public class StudentController extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    StudentService studentService = new StudentService();

   /* @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json"); // text html 형태로 출력 하겠다고 지정함
        PrintWriter out = response.getWriter(); // response로 부터 출력 장치를 확보

        String studentList = null;
        try {
            studentList = studentService.getStudentList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        out.println(studentList);
    }

     @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html"); // text html 형태로 출력 하겠다고 지정함
        PrintWriter out = response.getWriter(); // response로 부터 출력 장치를 확보

        String yourName = request.getParameter("your_name"); // request에서 화면으로 부터 넘어온 파라메터의 값을 추출 합니다.

        // html 내용을 출력
        out.println("<html>");
        out.println("hello, world<br/>");
        out.println("method : " + request.getMethod() + "<br/>");
        out.println("You'r name is " + yourName);
        out.println("</html>");
    }


    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html"); // text html 형태로 출력 하겠다고 지정함
        PrintWriter out = response.getWriter(); // response로 부터 출력 장치를 확보

        String yourName = request.getParameter("your_name"); // request에서 화면으로 부터 넘어온 파라메터의 값을 추출 합니다.

        // html 내용을 출력
        out.println("<html>");
        out.println("hello, world<br/>");
        out.println("method : " + request.getMethod() + "<br/>");
        out.println("You'r name is " + yourName);
        out.println("</html>");
    }


//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        logger.info(String.valueOf(request));
//        logger.info(String.valueOf(response));
//
//        GradeService gradeService = new GradeService();
//
//        //조회 결과를 담은 어드민 리스트
//        String studentDtoList = null;
//        try {
//            studentDtoList = gradeService.getGradeDetail();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        request.setAttribute("studentDtoList", studentDtoList);
//        request.getRequestDispatcher("/result").forward(request, response);
//    }

*/
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseVO> getStudent() {
        ResponseVO res = new ResponseVO();

        try {
            res = studentService.getStudentList();

        }catch (Exception e) {
            res = new ResponseVO();
            res._setPOMErrorCode(POMErrorCode.P_6000);
            res.setExceptionMessage(e.getLocalizedMessage());
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping(value = "/update", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object>  updateStudent(HttpServletRequest request, HttpServletResponse response){
        ResponseVO res = null;

        try{

            res = studentService.putStudentList(request);

        }catch (Exception e){
            res = new ResponseVO();
            res._setPOMErrorCode(POMErrorCode.P_6000);
            res.setExceptionMessage(e.getLocalizedMessage());
        }
        return new ResponseEntity(res, HttpStatus.OK);
    }


}
