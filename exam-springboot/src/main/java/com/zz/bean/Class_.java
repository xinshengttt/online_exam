package com.zz.bean;

/**
 * @author Becant
 * 2025-02-17-11:43
 */

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 班级 实体类
 */
@Data
@TableName("class")
public class Class_ {
    /**
     * 主键
     */
    @TableId
    private String id;
    /**
     * 班级名称
     */
    private String name;
    /**
     * 专业名称
     */
    private String discipline;
    /**
     * 年级
     */
    private String grade;
    /**
     * 班级人数
     */
    private Integer studentNum;
}
