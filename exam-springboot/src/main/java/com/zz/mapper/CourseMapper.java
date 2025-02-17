package com.zz.mapper;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.bean.Course;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    ArrayList<Course> selectByUId(Integer uId);

    /**
     * 查询该老师所教课程的所有学生
     *
     * @param uId 老师Id
     * @return
     */
    ArrayList<JSONObject> selectStudentAndCourse(Integer uId);

    Integer updateStudentByCourse(@Param("cId") Integer cId, @Param("ucId") Integer ucId);

    boolean addCourse(Course course);

    boolean deleteCourse(Integer cId);

    boolean updateName(Course course);

    Integer selectByCode(String code);

    boolean joinCourse(@Param("uId") Integer uId, @Param("cId") Integer cId);

    Integer isJoin(@Param("uId") Integer uId, @Param("cId") Integer cId);

    Integer deleteStudentByCourse(Integer ucId);

    /**
     * 用在这个函数关联com.zz.dao.ExamDao#selectOne(java.lang.Integer)
     * @param cId
     * @return
     */
    String selectNameByCid(Integer cId);

    /**
     * 学生查询已经加入的课程
     *
     * @param uId 学生Id
     * @return [{"teacherName": xxx, "courseName": xxx}]
     */
    ArrayList<JSONObject> selectChoiceCourseByUId(Integer uId);
}
