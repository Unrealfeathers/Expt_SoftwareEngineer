package com.expt.Expt_SoftwareEngineer.service.impl;

import com.expt.Expt_SoftwareEngineer.mapper.GradeMapper;
import com.expt.Expt_SoftwareEngineer.pojo.Grade;
import com.expt.Expt_SoftwareEngineer.pojo.PageBean;
import com.expt.Expt_SoftwareEngineer.service.GradeService;
import com.expt.Expt_SoftwareEngineer.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GradeServiceImpl implements GradeService {

    private final GradeMapper gradeMapper;

    public GradeServiceImpl(GradeMapper gradeMapper) {
        this.gradeMapper = gradeMapper;
    }

    @Override
    public PageBean<Grade> getCourseGradeList(Integer pageNum, Integer pageSize, String academicYear, Integer courseId, String courseName) {
        PageBean<Grade> pageBean = new PageBean<>();
        // 开启分页查询
        PageHelper.startPage(pageNum, pageSize);
        // 获取学生ID
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer typeId = (Integer) map.get("typeId");
        List<Grade> gradeList = gradeMapper.getCourseGradeList(academicYear, courseId, courseName, typeId);

        Page<Grade> page = (Page<Grade>) gradeList;
        pageBean.setTotal(page.getTotal());
        pageBean.setItems(page.getResult());

        return pageBean;
    }
}
