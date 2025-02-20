package com.zz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zz.service.TagService;
import com.zz.bean.Tag;
import com.zz.mapper.TagMapper;
import com.zz.utils.Code;
import com.zz.utils.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;

    public ApiResult<Integer> updateTag(JSONObject tag) {
        Integer integer = tagMapper.updateTag(tag);
        return new ApiResult<>(Code.UPDATE_OK, null, integer == 1 ? "修改成功" : "修改失败");
    }

    @Override
    public ApiResult<List<Tag>> selectAll(Integer uId) {
        ArrayList<Tag> tags = tagMapper.selectAll(uId);
        return new ApiResult<>(Code.GET_OK, tags, tags.size() > 0 ? "查询成功" : "查询失败");
    }

    @Override
    public ApiResult<Integer> addTag(JSONObject json) {
        Integer integer = tagMapper.addTag(json);
        return new ApiResult<>(Code.UPDATE_OK, integer, integer != 0 ? "标签添加成功" : "标签添加失败");
    }

    @Override
    public ApiResult<Integer> deleteTag(Integer tagId) {
        Integer integer = tagMapper.deleteTag(tagId);
        return new ApiResult<>(Code.UPDATE_OK, null, integer > 0 ? "标签删除成功" : "标签删除失败");

    }
}
