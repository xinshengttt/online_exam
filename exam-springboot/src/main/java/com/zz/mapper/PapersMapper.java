package com.zz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.bean.Course;
import com.zz.bean.Papers;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;


@Mapper
public interface PapersMapper extends BaseMapper<Papers> {

    ArrayList<Papers> selectAllByUId(Integer uId);

    /**
     * 添加试卷
     *
     * @param papers 试卷对象
     */
    Integer addPaper(Papers papers);

    /**
     * 选择试卷
     *
     * @param pId 试卷Id
     */
    ArrayList<Papers> getPaper(Integer pId);

    /**
     * 获取papers的content
     *
     * @param pId 试卷Id
     */
    String getPaperContent(Integer pId);

    /**
     * 删除试卷，逻辑删除
     *
     * @param pId 试卷Id
     */
    Integer deleteByPId(Integer pId);

    /**
     * 修改试卷名称
     *
     * @param pId  试卷Id
     * @param name 要修改的名称
     */
    Integer updateName(@Param("pId") Integer pId, @Param("name") String name);
}
