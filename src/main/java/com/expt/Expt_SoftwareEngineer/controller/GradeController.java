package com.expt.Expt_SoftwareEngineer.controller;

import com.expt.Expt_SoftwareEngineer.pojo.Grade;
import com.expt.Expt_SoftwareEngineer.pojo.PageBean;
import com.expt.Expt_SoftwareEngineer.pojo.Result;
import com.expt.Expt_SoftwareEngineer.service.GradeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {
    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/academicYear")
    public Result<List<String>> getAcademicYear() {
        List<String> list = gradeService.getAcademicYear();
        return Result.success(list);
    }

    @GetMapping("/course")
    public Result<PageBean<Grade>> getCourseGradeList(Integer pageNum, Integer pageSize,
                                                      @RequestParam(required = false) String academicYear,
                                                      @RequestParam(required = false) Integer courseId,
                                                      @RequestParam(required = false) String courseName) {
        PageBean<Grade> pageBean = gradeService.getCourseGradeList(pageNum, pageSize, academicYear, courseId, courseName);
        return Result.success(pageBean);
    }
    @GetMapping("/sport")
    public Result<PageBean<Grade>> getSportGradeList(Integer pageNum, Integer pageSize,
                                                      @RequestParam(required = false) String academicYear,
                                                      @RequestParam(required = false) Integer courseId,
                                                      @RequestParam(required = false) String courseName) {
        PageBean<Grade> pageBean = gradeService.getSportGradeList(pageNum, pageSize, academicYear, courseId, courseName);
        return Result.success(pageBean);
    }
    @GetMapping("/activity")
    public Result<PageBean<Grade>> getActivityGradeList(Integer pageNum, Integer pageSize,
                                                     @RequestParam(required = false) String academicYear,
                                                     @RequestParam(required = false) Integer courseId,
                                                     @RequestParam(required = false) String courseName) {
        PageBean<Grade> pageBean = gradeService.getActivityGradeList(pageNum, pageSize, academicYear, courseId, courseName);
        return Result.success(pageBean);
    }
}
