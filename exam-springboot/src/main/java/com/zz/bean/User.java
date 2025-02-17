package com.zz.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user")
public class User {
    @TableId(value = "u_id")
    @JsonProperty("uId")
    private Integer uId;
    @JsonProperty("rId")
    private Integer rId;
    private String username;
    private String password;
    private String email;
    private String emailCode;
    private LocalDateTime registerTime;

}
