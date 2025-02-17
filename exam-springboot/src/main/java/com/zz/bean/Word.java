package com.zz.bean;



import lombok.Data;

import java.util.Objects;

@Data
public class Word implements Comparable {

    // 词名
    private String name;
    // 词性
    private String pos;
    // 权重，用于词向量分析
    private Float weight;

    public Word(String name, String pos) {
        this.name = name;
        this.pos = pos;
    }
    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (this.name == null) {
            return -1;
        }
        if (o == null) {
            return 1;
        }
        if (!(o instanceof Word)) {
            return 1;
        }
        String t = ((Word) o).getName();
        if (t == null) {
            return 1;
        }
        return this.name.compareTo(t);
    }
}