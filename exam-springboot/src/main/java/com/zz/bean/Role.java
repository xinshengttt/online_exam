package com.zz.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@TableName("role")
public class Role {
    @TableId(value = "r_id")
    @JsonProperty("rId")
    private Integer rId;
    private String name;
}
