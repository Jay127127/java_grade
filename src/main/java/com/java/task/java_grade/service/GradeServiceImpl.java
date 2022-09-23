package com.java.task.java_grade.service;

import com.java.task.java_grade.mapper.GradeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class GradeServiceImpl implements GradeService {

    private GradeMapper gradeMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<HashMap<String, Object>> getGradeDetailExportList() throws Exception {
        List<HashMap<String,Object>> gradeDetailExportList = gradeMapper.getGradeDetailExportList();
        return gradeDetailExportList; //No camelCaseConvert
    }
}
