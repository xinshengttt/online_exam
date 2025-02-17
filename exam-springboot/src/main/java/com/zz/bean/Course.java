package com.zz.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("course")
public class Course {

    @TableId(value = "c_id")
    @JsonProperty("cId")
    private Integer cId;
    @JsonProperty("uId")
    private Integer uId;
    private String name;
    private String courseCode;
    private LocalDateTime createTime;

}
