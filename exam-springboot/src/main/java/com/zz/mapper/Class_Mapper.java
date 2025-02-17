package com.zz.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.bean.Class_;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Becant
 * 2025-02-17-13:49
 */
@Mapper
public interface Class_Mapper extends BaseMapper<Class_> {

    /**
     * 根据班级名称模糊查询班级列表
     * @param name 班级名称
     * @return
     */
    List<Class_> selectClassList(@Param("uId") Integer uId, @Param("name") String name);
}
