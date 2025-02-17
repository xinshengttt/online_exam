package com.zz.mapper;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.bean.Course;
import com.zz.bean.Topic;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface TopicMapper extends BaseMapper<Topic> {


    /**
     * @param uId：老师Id，由老师管理题目
     * @return 题目列表
     */
    ArrayList<Topic> selectByUId(@Param("uId") Integer uId);

    /**
     * 添加题目
     *
     * @param topic：题目
     * @return 添加条数
     */
    Integer addTopic(Topic topic);


    /**
     * 删除题目，逻辑删除
     *
     * @param tId 题目Id
     * @return 删除条数
     */
    Integer delTopic(Integer tId);

    /**
     * 修改题目信息
     *
     * @param topic 实体
     * @return 修改条数
     */
    Integer updateTopic(Topic topic);

    /**
     * 手动组卷，根据题目ID来组
     *
     * @param tIds 题目Id
     * @return 题目列表
     */
    ArrayList<Topic> topicToPapers(Integer[] tIds);


    /**
     * 题目条数，用来判断约束是否成功
     *
     * @param tagId 标签Id
     * @return 不同类型的题目数量
     */
    ArrayList<JSONObject> typeCount(Integer tagId);

    /**
     * 根据题目类型来查询题目
     *
     * @param typeId 类型Id
     * @return 题目列表
     */
    ArrayList<Topic> selectByTypeId(@Param("uId") Integer uId,@Param("typeId") Integer typeId,@Param("tagId") Integer tagId);
}
