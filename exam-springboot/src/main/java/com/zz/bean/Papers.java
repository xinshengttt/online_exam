package com.zz.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("papers")
public class Papers {
    @TableId(value = "p_id")
    @JsonProperty("pId")
    private Integer pId;
    @JsonProperty("uId")
    private Integer uId;
    private String name;
    private String content;
    private LocalDateTime createTime;
    private Integer isExist;

    public Papers() {
    }

    public Papers(Integer uId, String name, String content, LocalDateTime createTime) {
        this.uId = uId;
        this.name = name;
        this.content = content;
        this.createTime = createTime;
    }

    public Papers(String name, String content, LocalDateTime createTime) {
        this.name = name;
        this.content = content;
        this.createTime = createTime;
    }
}
