package com.zz.controller;

import com.zz.bean.Class_;
import com.zz.service.Class_Service;
import com.zz.utils.Code;
import com.zz.utils.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Becant
 * 2025-02-17-11:47
 */
@RestController
@RequestMapping("/api/class")
public class Class_Controller {

    @Autowired
    private Class_Service class_service;

    /**
     * 根据班级名称模糊查询班级列表
     * @param name 班级名称
     * @return
     */
    @GetMapping("/list/{uId}/{name}")
    public ApiResult<List<Class_>> getList(@PathVariable Integer uId, @PathVariable String name) {
        List<Class_> list = class_service.getList(uId, name);
        return new ApiResult<>(!list.isEmpty() ? Code.GET_OK : Code.GET_ERR,
                list, !list.isEmpty() ? "班级查询成功" : "班级查询失败");
    }

    /**
     * 查询班级列表
     * @return
     */
    @GetMapping("/list/{uId}")
    public ApiResult<List<Class_>> getList(@PathVariable Integer uId) {
        List<Class_> list = class_service.getList(uId, "");
        return new ApiResult<>(!list.isEmpty() ? Code.GET_OK : Code.GET_ERR,
                list, !list.isEmpty() ? "班级查询成功" : "班级查询失败");
    }
}
