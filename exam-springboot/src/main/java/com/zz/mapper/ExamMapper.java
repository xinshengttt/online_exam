package com.zz.mapper;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.bean.Course;
import com.zz.bean.Exam;
import com.zz.bean.Papers;
import com.zz.bean.StudentExam;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Mapper
//@Repository
public interface ExamMapper extends BaseMapper<Exam> {

    //创建考试
    public Integer createExam(Exam exam);

    //    修改信息
    public Integer updateExamInfo(Exam exam);

    // 考试开启

    // 注销考试 is_exist 默认状态为1 注销为0
    public Integer deleteExam(Integer examId);

    /**
     * 根据教师id查询与其相关的所有考试信息
     *
     * @param uId 教师的uid
     * @return
     */
    // 查询所有 All 会获取papers的内容
    public List<Exam> selectAll(Integer uId);


    /**
     * 根据eid查询整个考试
     *
     * @param eId
     * @return
     */
    public Exam selectOneByEId(Integer eId);

    /**
     * 根据学生的uid查询这个学生的考试列表
     * 这个方法查询学生的所有课程
     *
     * @param uId
     * @return
     */
    List<Course> getCoursesByUid(Integer uId);

    /**
     * 根据方法getCoursesByUid的结果集进行查询，既根据学生的所属课程进行查询该学生所有的考试信息
     * @param cIds getCoursesByUid的结果集元素
     * @return
     */
    ArrayList<JSONObject> getExamsByCourseId(ArrayList<Integer> cIds);

    /**
     * 存储学生考试提交记录以及试卷
     *
     * @param studentExam
     * @return
     */
    public Integer addExamRecord(StudentExam studentExam);

    public Integer selectIsExist(StudentExam studentExam);

    /**
     * 查询所有的考试，来更新状态
     */
    public ArrayList<Exam> findAll();

    public Integer updateStatus(Exam exam);

    Integer isSubmit(@Param("uId") Integer uId, @Param("uId") Integer eId);

    ArrayList<JSONObject> submitList(Integer uId);
}
