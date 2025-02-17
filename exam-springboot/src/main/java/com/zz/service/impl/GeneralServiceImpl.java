package com.zz.service.impl;

import com.zz.service.GeneralService;
import com.zz.bean.Difficulty;
import com.zz.bean.Role;
import com.zz.bean.Tag;
import com.zz.bean.TopicType;
import com.zz.mapper.DifficultyMapper;
import com.zz.mapper.RoleMapper;
import com.zz.mapper.TagMapper;
import com.zz.mapper.TopicTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GeneralServiceImpl implements GeneralService {

    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private TopicTypeMapper topicTypeMapper;
    @Autowired
    private DifficultyMapper difficultyMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public ArrayList<Tag> getTagList(Integer uId) {
        return tagMapper.selectAll(uId);
    }

    @Override
    public ArrayList<TopicType> getTypeList() {
        return topicTypeMapper.selectAll();
    }

    @Override
    public ArrayList<Difficulty> getDifficultyList() {
        return difficultyMapper.selectAll();
    }

    @Override
    public ArrayList<Role> getRoleList() {
        return roleMapper.selectAll();
    }
}
