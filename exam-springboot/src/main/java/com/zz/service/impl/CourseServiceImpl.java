package com.zz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zz.service.CourseService;
import com.zz.bean.Course;
import com.zz.mapper.CourseMapper;
import com.zz.utils.Code;
import com.zz.utils.CourseUtils;
import com.zz.utils.result.ApiResult;
import com.zz.utils.result.TempResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public ApiResult<List<Course>> selectByUId(Integer uId) {
        ArrayList<Course> courses = courseMapper.selectByUId(uId);
        System.out.println(courses);
        boolean isEmpty = courses.isEmpty();
        return new ApiResult<>(Code.GET_OK, courses, !isEmpty ? "查询成功！" : "查询结果为空！");
    }

    @Override
    public boolean addCourse(Course course) {
        course.setCourseCode(CourseUtils.getCourseCode());
        course.setCreateTime(LocalDateTime.now());
        return courseMapper.addCourse(course);
    }

    @Override
    public boolean deleteCourse(Integer cId) {
        return courseMapper.deleteCourse(cId);
    }

    @Override
    public boolean updateName(Course course) {
        return courseMapper.updateName(course);
    }

    @Override
    public TempResult joinCourse(Integer uId, String code) {
        Integer cId = courseMapper.selectByCode(code);
        TempResult tempResult = new TempResult();
        if (cId != null) {
            Integer count = courseMapper.isJoin(uId, cId);
            if (count == 0) {
                tempResult.setFlag(courseMapper.joinCourse(uId, cId));
                tempResult.setMsg(tempResult.isFlag() ? "课程加入成功！" : Code.ERROR_MSG);
            } else {
                tempResult.setFlag(false);
                tempResult.setMsg("已加入课程，请勿重复加入！");
            }
        } else {
            tempResult.setFlag(false);
            tempResult.setMsg("课程不存在，请检查课程码是否正确！");
        }
        return tempResult;
    }

    /**
     * @param uId 教师所教授课程cid的的列表
     * @return 返回apiresult
     */
    public ApiResult<List<JSONObject>> selectStudentAndCourse(Integer uId) {
        ArrayList<JSONObject> jsonObjects = courseMapper.selectStudentAndCourse(uId);
        ApiResult<List<JSONObject>> apiResult = new ApiResult<>();
        apiResult.setData(jsonObjects);
        if (apiResult.getData() != null) {
            apiResult.setCode(Code.GET_OK);
            apiResult.setMsg("查询成功");
        } else {
            apiResult.setCode(Code.GET_ERR);
            apiResult.setMsg("查询失败");
        }
        return apiResult;
    }

    @Override
    public ApiResult<List<JSONObject>> searchStudentAndCourse(Integer uId, String studentIdOrName) {
        ArrayList<JSONObject> studentList = courseMapper.selectStudentAndCourse(uId);

        List<JSONObject> res = studentList.stream()
                .filter(item -> studentIdOrName.equals(item.getString("uId"))
                        || studentIdOrName.equals(item.getString("userName"))
                        || studentIdOrName.equals(item.getString("courseName")))
                .collect(Collectors.toList());

        boolean isSuccess = !res.isEmpty();
        return new ApiResult<>(
                Code.GET_OK, res,
                isSuccess ? "查询出" + res.size() + "名学生！" : "未找到该学生！");
    }

    @Override
    public ApiResult<List<Course>> searchCourseByName(Integer uId, String courseName) {
        ArrayList<Course> courseList = courseMapper.selectByUId(uId);

        List<Course> res = courseList.stream()
                .filter(item -> courseName.equals(item.getName()))
                .collect(Collectors.toList());

        boolean isSuccess = !res.isEmpty();
        return new ApiResult<>(
                Code.GET_OK, res,
                isSuccess ? "查询出" + res.size() + "门课程！" : "未找到该课程！");
    }

    @Override
    public ApiResult<Object> updateStudentByCourse(Integer cId, Integer ucId) {
        Integer integer = courseMapper.updateStudentByCourse(cId, ucId);
        boolean isSuccess = integer != 0;
        return new ApiResult<>(isSuccess ? Code.UPDATE_OK : Code.UPDATE_ERR, null,
                isSuccess ? "学生所选课程修改成功！" : "修改失败！");
    }

    @Override
    public ApiResult<Object> deleteStudentByCourse(Integer ucId) {
        Integer integer = courseMapper.deleteStudentByCourse(ucId);
        boolean isSuccess = integer != 0;
        return new ApiResult<>(isSuccess ? Code.DELETE_OK : Code.DELETE_ERR, null,
                isSuccess ? "已经该学生移除课程！" : "删除失败！");
    }

    @Override
    public ApiResult<ArrayList<JSONObject>> selectChoiceCourseByUId(Integer uId) {
        ArrayList<JSONObject> data = courseMapper.selectChoiceCourseByUId(uId);
        boolean isSuccess = !data.isEmpty();
        return new ApiResult<ArrayList<JSONObject>>(isSuccess ? Code.GET_OK : Code.GET_ERR, data,
                isSuccess ? "查询" + data.size() + "条数据！" : "数据查询为空！");
    }
//    @Override
//    public ApiResult selectStudentAndCourse(List<Integer> cIdList) {
//        ArrayList<JSONObject> jsonObjects = courseDao.selectStudentAndCourse(cIdList);
//        ApiResult apiResult = new ApiResult();
//        apiResult.setData(jsonObjects);
//        if (apiResult.getData() != null) {
//            apiResult.setCode(Code.GET_OK);
//            apiResult.setMsg("查询成功");
//        } else {
//            apiResult.setCode(Code.GET_ERR);
//            apiResult.setMsg("查询失败");
//        }
//        return apiResult;
//    }


}
