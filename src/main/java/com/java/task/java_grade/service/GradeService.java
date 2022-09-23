package com.java.task.java_grade.service;

import java.util.HashMap;
import java.util.List;

public interface GradeService {
    List<HashMap<String, Object>> getGradeDetailExportList() throws Exception;
}
