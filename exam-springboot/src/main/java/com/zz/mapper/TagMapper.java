package com.zz.mapper;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.bean.Course;
import com.zz.bean.Tag;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    ArrayList<Tag> selectAll(Integer uId);

    String selectById(Integer tagId);

    Integer addTag(JSONObject tag);

    Integer updateTag(JSONObject tag);

    Integer deleteTag(Integer tagId);
}
