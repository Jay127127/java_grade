package com.java.task.java_grade.controller;

import java.util.*;

import com.java.task.java_grade.entity.StudentDto;

import static com.java.task.java_grade.controller.ReadCSV.readCSVFile;

public class app {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int n;

        Scanner scanner = new Scanner(System.in);
        System.out.print("확인할 학생 수를 입력하시오 >> ");
        n = scanner.nextInt();

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

//      ================================ csv 파일 내보내기 ==================================================================
        ExportCSV exportCSV = new ExportCSV();
        String exportPath = "C:/Users/Intellivix/Desktop/java_task/new.csv";
        exportCSV.exportStudent(studentDtoList, exportPath);

//      ================================ csv 파일 읽어오기 ==================================================================
        String readPath = "C:/Users/Intellivix/Desktop/java_task/new.csv";
        HashMap<String,Object> csvData = readCSVFile(readPath);

        System.out.println("cvsData ::: " +csvData);

//      ================================ 검색 기능 만들기 ==================================================================

        /*System.out.println("검색할 이름을 입력 :: ");
        String nameInput = scanner.next();

        List<StudentDto> searchedStudentList = new ArrayList<>();
        List<StudentDto> studentDtoListRead = (List<StudentDto>) csvData.get("studentDtoList");

        for (StudentDto studentDto : studentDtoListRead) {
            if (studentDto.getStudentName().contains(nameInput)) {
                searchedStudentList.add(studentDto);
            }
        }*/


        System.out.println("검색할 이름을 입력 :: ");
        String nameInput = scanner.next();

        List<StudentDto> searchedStudentList = new ArrayList<>();

        if(csvData.containsKey(nameInput)){
            StudentDto searched = (StudentDto) csvData.get(nameInput);
            searchedStudentList.add(searched);
        };

        for(StudentDto s: searchedStudentList){
            System.out.println(s);
        }


//      ================================ 다시 CSV 내보내기 ==================================================================
        exportCSV.exportStudent(searchedStudentList, exportPath);










//      ================================ 엑셀 파일로 내보내기 ==================================================================

        /*try {
            File location = new File("C:/Users/Intellivix/Desktop/java_task");
            String excelFileName = "학생 점수 상세 [" + studentDtoList.size() + "명] " + LocalDate.now() +"";
            String excelFileFullPath = location + "/" + excelFileName+ ".xlsx";

            LicenseDetailExport export = new LicenseDetailExport();
            XSSFWorkbook workbook = export.generate(studentDtoList);

            FileOutputStream fileOutputStream = new FileOutputStream(excelFileFullPath);
            workbook.write(fileOutputStream);

            workbook.close();
            fileOutputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
    }
}

