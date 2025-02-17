package com.zz.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user")
public class User {
    /**
     * 主键
     */
    @TableId(value = "u_id")
    @JsonProperty("uId")
    private Integer uId;
    /**
     * 班级id
     */
    @JsonProperty("rId")
    private Integer classId;
    /**
     * 角色id
     */
    private Integer rId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 邮箱验证码
     */
    private String emailCode;
    /**
     * 注册时间
     */
    private LocalDateTime registerTime;

}
