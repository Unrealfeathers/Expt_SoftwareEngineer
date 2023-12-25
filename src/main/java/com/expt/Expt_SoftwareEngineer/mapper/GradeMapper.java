package com.expt.Expt_SoftwareEngineer.mapper;

import com.expt.Expt_SoftwareEngineer.pojo.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMapper {
    // 获取课程成绩
    List<Grade> getCourseGradeList(String academicYear, Integer courseId, String courseName, Integer typeId);

}
