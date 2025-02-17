package com.zz.service;

import com.zz.bean.Class_;

import java.util.List;

/**
 * @author Becant
 * 2025-02-17-13:48
 */
public interface Class_Service {
    /**
     * 根据班级名称模糊查询班级列表
     * @param uId 教师id
     * @param name 班级名称
     * @return
     */
    List<Class_> getList(Integer uId, String name);
}
