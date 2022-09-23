package com.java.task.java_grade.controller;

import com.java.task.java_grade.service.GradeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class GradeController {
    private GradeService gradeService;

    @Autowired
    public void setGradeService(GradeService gradeService) { this.gradeService = gradeService; }


    /** 학생 점수 내보내기 **/
    @GetMapping(value = "/grade/export")
    public void getLicenseDetailExport(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

        OutputStream ostream = response.getOutputStream();

        //라이선스 상세 및 제품 - 조회
        List<HashMap<String,Object>> gradeDetailExportList = gradeService.getGradeDetailExportList();
        if(gradeDetailExportList.size() == 0) throw new Exception();

        //엑셀 내보내기
        /*try {
            LicenseDetailExport export = new LicenseDetailExport();
            // workbook = export.generate();
            String filename = "라이선스 상세 " + gradeDetailExportList.get(0).get("licNumber");
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename=\""+ new String(filename.getBytes("UTF-8"),
                    "ISO-8859-1") +".xlsx\"");
            //workbook.write(ostream);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (ostream != null) {
                ostream.close();
            }
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }*/
    }

}
