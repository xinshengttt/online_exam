package com.zz.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.bean.Course;
import com.zz.bean.Difficulty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface DifficultyMapper extends BaseMapper<Difficulty> {

    ArrayList<Difficulty> selectAll();

    String selectById(Integer dId);
}
