package com.expt.Expt_SoftwareEngineer.service;

import com.expt.Expt_SoftwareEngineer.pojo.Grade;
import com.expt.Expt_SoftwareEngineer.pojo.PageBean;

public interface GradeService {

    // 课程成绩列表查询
    PageBean<Grade> getCourseGradeList(Integer pageNum, Integer pageSize, String academicYear, Integer courseId, String courseName);
}
