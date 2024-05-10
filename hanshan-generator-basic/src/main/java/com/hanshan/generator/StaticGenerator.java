package com.hanshan.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * 静态代码生成器
 */
public class StaticGenerator {

    public static void main(String[] args) {
        //当前项目的根目录
        String propertyPath = System.getProperty("user.dir");
        //输入路径
        String inputPath = propertyPath + File.separator + "hanshan-generator-demo-projects" + File.separator + "acm-template";
        //输出路径
        String outputPath = propertyPath;
        //复制
        copyFileByHutool(inputPath, outputPath);
    }

    /**
     * 拷贝文件
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     */
    public static void copyFileByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }
}
