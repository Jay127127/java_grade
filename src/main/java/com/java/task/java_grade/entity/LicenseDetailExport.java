
package com.java.task.java_grade.entity;

import org.apache.logging.log4j.util.Strings;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.*;

import java.util.*;

public class LicenseDetailExport {
    XSSFWorkbook workbook;
    XSSFCellStyle headerStyle;
    XSSFCellStyle normalStyle;
    Font fontStyle;
    private CellStyle percentStyle;

    public LicenseDetailExport() {
        this.workbook= new XSSFWorkbook();
        this.createCellStyles();
    }

    void createCellStyles() {
        // 기본 폰트
        this.fontStyle = this.workbook.createFont();
        this.fontStyle.setFontName("맑은 고딕");

        // 표 헤더컬럼 셀 스타일
        this.headerStyle = this.workbook.createCellStyle();
        this.headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        this.headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        this.headerStyle.setFont(this.fontStyle);
        this.headerStyle.setAlignment(HorizontalAlignment.CENTER);
        this.setBorderStyle(this.headerStyle);

        // 표 바디컬럼 셀 스타일
        this.normalStyle = this.workbook.createCellStyle();
        this.normalStyle.setFont(this.fontStyle);
        setBorderStyle(this.normalStyle);
    }


    /**
     * 셀에 테두리 설정 추가
     *
     * @param style
     */

    void setBorderStyle(XSSFCellStyle style) {
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
    }


    /**
     * width값을 엑셀 사용하는 넓이값으로 변경
     * sheet.setDefaultColumnWidth(20) 값은 입력된 값으로 적용되는 반면
     * sheet.setColumnWidth(0, getExcelPoint(30)) 개별 컬럼의 넓은 변환 된 값을 적용해야 함
     *
     * @param width
     * @return
     */

    int getExcelPoint(float width) {
        return (int) Math.floor((width * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
    }


/**
     * 표 헤더컬럼 생성
     *
     * @param row
     * @param cellnum
     * @param value
     */

    void createHCell(XSSFRow row, int cellnum, String value) {
        XSSFCell cell = row.createCell(cellnum);
        cell.setCellStyle(this.headerStyle);
        cell.setCellValue(value);
    }


/**
     * 표 바디컬럼 생성
     * value값이 숫자이거나, %가 포함되어 있을 경우 숫자형으로 CellType을 설정
     *
     * @param row
     * @param cellnum
     * @param value
     */

    void createVCell(XSSFRow row, int cellnum, String value) {
        XSSFCell cell = row.createCell(cellnum);
        if (value.matches("\\d+(\\.\\d+)?$") == true) {
            cell.setCellStyle(this.normalStyle);
            cell.setCellType(CellType.NUMERIC);
            cell.setCellValue(Double.parseDouble(value));
        } else if (value.matches("\\d+(\\.\\d+)?%$") == true) {
            cell.setCellStyle(this.percentStyle);
            cell.setCellType(CellType.NUMERIC);
            cell.setCellValue(Double.parseDouble(value.replace("%", "")));
        } else {
            cell.setCellStyle(this.normalStyle);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(value);
        }
    }


/**
     * 엑셀시트 생성
     *
     * @param rows {@link List}
     */

    public XSSFWorkbook generate(List<StudentDto> rows) {
        int cellnum = 0;
        List<String> headerTitle = new ArrayList<String>() {
            {
                add("등수");
                add("학생번호");
                add("학생 이름");
                add("국어");
                add("영어");
                add("수학");
                add("사회");
                add("과학");
                add("총점");
                add("평균");
            }
        };
        List<String> headerColumn = new ArrayList<String>() {
            {
                add("rank");
                add("studentNo");
                add("studentName");
                add("korean");
                add("english");
                add("math");
                add("history");
                add("science");
                add("total");
                add("average");
            }
        };
        XSSFSheet sheet = this.workbook.createSheet("학생점수표");
        sheet.setDefaultColumnWidth(18);
        XSSFRow row = sheet.createRow(0);
        for (Object title : headerTitle) {
            this.createHCell(row, cellnum, title.toString());
            cellnum++;
        }

        String value = null;
        StudentDto data;
        for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
            cellnum = 0;
            data = rows.get(rowIndex);
            row = sheet.createRow(rowIndex + 1);
            for (String key : headerColumn) {
                if(key.equals(key)){
                    value = this.getValue(data,key);
                }
                createVCell(row, cellnum, value);
                cellnum++;
            }
        }

        return this.workbook;
    }

    String getValue(StudentDto data, String key) {
        String value = null;
        switch (key){
            case "studentNo" :
                value = String.valueOf(data.getStudentNo()); break;
            case "studentName" :
                value = data.getStudentName(); break;
            case "korean" :
                value = String.valueOf(data.getKorean()); break;
            case "english" :
                value = String.valueOf(data.getEnglish()); break;
            case "math" :
                value = String.valueOf(data.getMath()); break;
            case "history" :
                value = String.valueOf(data.getHistory()); break;
            case "science" :
                value = String.valueOf(data.getScience()); break;
            case "total" :
                value = String.valueOf(data.getTotal()); break;
            case "average" :
                value = String.valueOf(data.getAverage()); break;
            case "rank" :
                value = String.valueOf(data.getRank()); break;
        }
        
        return value == null? Strings.EMPTY: value.toString();
    }

}
