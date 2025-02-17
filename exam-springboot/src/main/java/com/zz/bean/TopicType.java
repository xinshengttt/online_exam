package com.zz.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("topic_type")
public class TopicType {
    @TableId(value = "type_id")
    private Integer typeId;
    private String name;
}
