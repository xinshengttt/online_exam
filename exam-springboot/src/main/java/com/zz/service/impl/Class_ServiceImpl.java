package com.zz.service.impl;

import com.zz.bean.Class_;
import com.zz.mapper.Class_Mapper;
import com.zz.service.Class_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author Becant
 * 2025-02-17-13:48
 */
@Service
public class Class_ServiceImpl implements Class_Service {

    @Autowired
    private Class_Mapper class_mapper;

    /**
     * 根据班级名称模糊查询班级列表
     * @param uId 教师id
     * @param name 班级名称
     * @return
     */
    @Override
    public List<Class_> getList(Integer uId, String name) {
        return class_mapper.selectClassList(uId, name);
    }
}
