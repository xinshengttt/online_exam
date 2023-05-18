package com.zz.Service.impl;

import com.zz.Service.GeneralService;
import com.zz.bean.Difficulty;
import com.zz.bean.Tag;
import com.zz.bean.TopicType;
import com.zz.dao.DifficultyDao;
import com.zz.dao.TagDao;
import com.zz.dao.TopicTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GeneralServiceImpl implements GeneralService {

    @Autowired
    private TagDao tagDao;
    @Autowired
    private TopicTypeDao topicTypeDao;
    @Autowired
    private DifficultyDao difficultyDao;

    @Override
    public ArrayList<Tag> getTagList(Integer uId) {
        return tagDao.selectAll(uId);
    }

    @Override
    public ArrayList<TopicType> getTypeList() {
        return topicTypeDao.selectAll();
    }

    @Override
    public ArrayList<Difficulty> getDifficultyList() {
        return difficultyDao.selectAll();
    }
}
