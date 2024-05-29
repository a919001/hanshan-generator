package ${basePackage}.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * 静态代码生成器
 */
public class StaticGenerator {

    /**
     * 拷贝文件
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     */
    public static void copyFileByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }
}
