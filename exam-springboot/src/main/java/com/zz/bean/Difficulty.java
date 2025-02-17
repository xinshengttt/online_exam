package com.zz.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@TableName("difficulty")
public class Difficulty {
    @TableId(value = "d_id")
    @JsonProperty("dId")
    private Integer dId;
    private String name;

}
