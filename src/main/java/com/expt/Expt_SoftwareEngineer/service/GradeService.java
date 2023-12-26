package com.expt.Expt_SoftwareEngineer.service;

import com.expt.Expt_SoftwareEngineer.pojo.Grade;
import com.expt.Expt_SoftwareEngineer.pojo.PageBean;

import java.util.List;

public interface GradeService {

    // 学年查询
    List<String> getAcademicYear();

    // 课程成绩列表查询
    PageBean<Grade> getCourseGradeList(Integer pageNum, Integer pageSize, String academicYear, Integer courseId, String courseName);

    // 课程成绩列表查询
    PageBean<Grade> getSportGradeList(Integer pageNum, Integer pageSize, String academicYear, Integer courseId, String courseName);

    // 活动成绩列表查询
    PageBean<Grade> getActivityGradeList(Integer pageNum, Integer pageSize, String academicYear, Integer courseId, String courseName);
}
