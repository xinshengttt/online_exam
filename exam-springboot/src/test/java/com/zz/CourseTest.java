package com.zz;

import com.alibaba.fastjson.JSONObject;
import com.zz.controller.CourseController;
import com.zz.mapper.CourseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class CourseTest {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseController courseController;

    @Test
    void joinTest() {
        System.out.println(courseMapper.isJoin(2, 8));
    }

    @Test
    void getStudentbyuid() {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(1);
        list.add(2);
        ArrayList<JSONObject> jsonObjects = courseMapper.selectStudentAndCourse(9);
        System.out.println("jsonObjects SIZE = =========" + jsonObjects.size());
        for (JSONObject j :
                jsonObjects) {
            System.out.println(j);
        }
    }
}
