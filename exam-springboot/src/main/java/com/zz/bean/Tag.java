package com.zz.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@TableName("tag")
public class Tag {
    @TableId(value = "tag_id")
    private Integer tagId;
    @JsonProperty("uId")
    private Integer uId;
    private String name;

}
