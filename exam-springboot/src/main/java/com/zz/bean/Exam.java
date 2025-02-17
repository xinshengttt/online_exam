package com.zz.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("exam")
public class Exam {
    @TableId(value = "e_id")
    @JsonProperty("eId")
    private Integer eId;
    @JsonProperty("uId")
    private Integer uId;
    @JsonProperty("cId")
    private Integer cId;
    @JsonProperty("pId")
    private Integer pId;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer status;
    private Integer isExist;
    private String content;
    private String courseName;
    private String teacherName;
}
