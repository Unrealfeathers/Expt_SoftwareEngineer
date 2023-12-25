package com.expt.Expt_SoftwareEngineer.controller;

import com.expt.Expt_SoftwareEngineer.pojo.Grade;
import com.expt.Expt_SoftwareEngineer.pojo.PageBean;
import com.expt.Expt_SoftwareEngineer.pojo.Result;
import com.expt.Expt_SoftwareEngineer.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/course")
    public Result<PageBean<Grade>> getCourseGradeList(Integer pageNum, Integer pageSize,
                                                      @RequestParam(required = false) String academicYear,
                                                      @RequestParam(required = false) Integer courseId,
                                                      @RequestParam(required = false) String courseName) {
        PageBean<Grade> pageBean = gradeService.getCourseGradeList(pageNum, pageSize, academicYear, courseId, courseName);
        return Result.success(pageBean);
    }
}
