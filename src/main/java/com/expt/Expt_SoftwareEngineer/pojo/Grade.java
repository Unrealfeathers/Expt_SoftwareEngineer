package com.expt.Expt_SoftwareEngineer.pojo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Grade {
    @NotNull
    // 课程ID
    private Integer courseId;
    // 课程名称
    private String courseName;
    // 授课教师
    private String courseTeacher;
    // 课程学分
    private Double courseCredit;
    // 学生考试成绩
    private Double courseScore;
}
