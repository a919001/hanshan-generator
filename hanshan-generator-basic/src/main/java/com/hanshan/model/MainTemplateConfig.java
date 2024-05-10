package com.hanshan.model;

import lombok.Data;

/**
 * 动态模板配置
 */
@Data
public class MainTemplateConfig {
    //作者注释
    private String author = "寒山";

    //输出信息
    private String outputText = "sum = ";

    //是否循环
    private boolean loop;
}
