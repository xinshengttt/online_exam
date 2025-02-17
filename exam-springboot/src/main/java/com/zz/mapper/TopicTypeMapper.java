package com.zz.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.bean.Course;
import com.zz.bean.TopicType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface TopicTypeMapper extends BaseMapper<TopicType> {

    ArrayList<TopicType> selectAll();

    /**
     * 用在关联映射
     * @param typeId 类型Id
     */
    String selectById(Integer typeId);
}
