package com.zz.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("student_exam")
public class StudentExam {
    @TableId(value = "se_id")
    @JsonProperty("seId")
    private Integer seId;
    @JsonProperty("uId")
    private Integer uId;
    @JsonProperty("eId")
    private Integer eId;
    private String rightStudentAnswer;

    private LocalDateTime createTime;

    public StudentExam() {
    }

    public StudentExam(Integer uId, Integer eId, String rightStudentAnswer) {
        this.uId = uId;
        this.eId = eId;
        this.rightStudentAnswer = rightStudentAnswer;
    }

}
