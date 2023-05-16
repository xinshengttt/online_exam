package com.zz.controller;

import com.zz.Service.CourseService;
import com.zz.bean.Course;
import com.zz.utils.Code;
import com.zz.utils.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public ApiResult addCourse(@RequestBody Course course) {
        System.out.println(course);
        boolean flag = courseService.addCourse(course);
        return new ApiResult(flag ? Code.SAVA_OK : Code.SAVA_ERR, null,
                flag ? "课程创建成功！" : "课程创建失败！");
    }

    @PostMapping("/updateName")
    public ApiResult updateName(@RequestBody Course course) {
        boolean flag = courseService.updateName(course);
        return new ApiResult(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, null,
                flag ? "课程名称修改成功！" : "课程名称修改失败！");
    }

    @DeleteMapping("/{cId}")
    public ApiResult deleteCourse(@PathVariable Integer cId) {
        boolean flag = courseService.deleteCourse(cId);
        return new ApiResult(flag ? Code.DELETE_OK : Code.DELETE_ERR, null,
                flag ? "课程删除成功！" : "课程删除失败！");
    }
}
