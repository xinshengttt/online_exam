package com.zz.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("topic")
public class Topic {
    @TableId(value = "t_id")
    @JsonProperty("tId")
    private Integer tId;
    @JsonProperty("uId")
    private Integer uId;
    private Integer typeId;
    private String typeName;
    private Integer tagId;
    private String tagName;
    private Integer difficultyId;
    private String difficultyName;
    private String question;
    private String answer;
    private Integer status;
    private Integer isExist;
    private String isStandardAnswer;
    private LocalDateTime createTime;
}
