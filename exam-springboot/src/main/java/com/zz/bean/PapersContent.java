package com.zz.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 用来存放单个题目内容，形成JSONObject存在到试卷中
 */
@Data
public class PapersContent {
    @JsonProperty("tId")
    private Integer tId;
    private String question;
    private String answer;
    private Integer score;

    public PapersContent() {
    }

    public PapersContent(String question, String answer, Integer score) {
        this.question = question;
        this.answer = answer;
        this.score = score;
    }

    public PapersContent(Integer tId, String question, String answer) {
        this.tId = tId;
        this.question = question;
        this.answer = answer;
    }

    public PapersContent(Integer tId, String question, String answer, Integer score) {
        this.tId = tId;
        this.question = question;
        this.answer = answer;
        this.score = score;
    }
}
