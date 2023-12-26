package com.expt.Expt_SoftwareEngineer.mapper;

import com.expt.Expt_SoftwareEngineer.pojo.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GradeMapper {

    // 获取全部学年
    @Select("SELECT term.term_name FROM term")
    List<String> getAcademicYear();

    // 获取课程成绩
    List<Grade> getCourseGradeList(String academicYear, Integer courseId, String courseName, Integer typeId);

    // 获取体育成绩
    List<Grade> getSportGradeList(String academicYear, Integer courseId, String courseName, Integer typeId);

    // 获取活动成绩
    List<Grade> getActivityGradeList(String academicYear, Integer courseId, String courseName, Integer typeId);
}
