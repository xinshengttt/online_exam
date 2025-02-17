package com.zz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.bean.Course;
import com.zz.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

@Mapper
//@Repository
public interface UserMapper extends BaseMapper<User> {

    Integer addUser(User user);

    ArrayList<User> selectByEmail(User user);

    Integer updateUser(User user);

    String getNameById(Integer uId);
}
