package com.zz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zz.service.TopicService;
import com.zz.bean.Topic;
import com.zz.bean.PapersContent;
import com.zz.mapper.TopicMapper;
import com.zz.mapper.TopicTypeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TopicTest {

    @Autowired
    private TopicMapper topicMapper;
    @Autowired
    private TopicTypeMapper topicTypeMapper;

    @Autowired
    private TopicService topicService;

    @Test
    void test() {
    }

    @Test
    void selectTest() {
        System.out.println(topicMapper.selectByUId(9));
    }

    @Test
    void addTest() {
        String test = "['A']";
        JSONArray parse = (JSONArray) JSON.parse(test);
        System.out.println();
        System.out.println(parse);
    }

    @Test
    void topicToPapersTest() {
        JSONObject result = new JSONObject();
        for (Topic topic : topicMapper.topicToPapers(new Integer[]{1, 2, 3})) {
            result.put(String.valueOf(topic.getTId()), new PapersContent(topic.getQuestion(), topic.getAnswer(), 1));
        }
        System.out.println(result);
    }

    @Test
    void typeCountTest() {
        System.out.println(topicMapper.typeCount(2));
    }

    @Test
    void topicToRandomPapersTest() {
//        String params = "{\n" +
//                "    \"uId\": 9,\n" +
//                "    \"tagId\": 1,\n" +
//                "    \"papersName\": \"政治\",\n" +
//                "    \"topicScore\": {\n" +
//                "        \"1\": 1,\n" +
//                "        \"2\": 2,\n" +
//                "        \"3\": 2,\n" +
//                "        \"4\": 2,\n" +
//                "        \"5\": 5\n" +
//                "    },\n" +
//                "    \"check\": {\n" +
//                "        \"typeCheck\": {\n" +
//                "            \"1\": 3,  // type_id: num\n" +
//                "            \"2\": 0,\n" +
//                "            \"3\": 0,\n" +
//                "            \"4\": 0,\n" +
//                "            \"5\": 1\n" +
//                "        },\n" +
//                "        \"difficultyCheck\": {\n" +
//                "            \"1\": 0.7,  // 百分比\n" +
//                "            \"2\": 0.2,\n" +
//                "            \"3\": 0.1\n" +
//                "        } \n" +
//                "    }\n" +
//                "}";
//        JSONObject check = JSON.parseObject(params);
//        topicService.topicToPapers(check);
    }
}
