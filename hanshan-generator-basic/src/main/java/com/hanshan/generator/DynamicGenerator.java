package com.hanshan.generator;

import com.hanshan.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 动态代码生成器
 */
public class DynamicGenerator {

    public static void main(String[] args) throws IOException, TemplateException {
        //设置模板文件所在的路径
        String projectPath = System.getProperty("user.dir") + File.separator + "hanshan-generator-basic";
        String inputPath = projectPath + "/src/main/resources/templates/MainTemplate.java.ftl";

        //生成文件输出路径
        String outputPath = projectPath + File.separator + "MainTemplate.java";

        //数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("侯音");
        mainTemplateConfig.setOutputText("输出结果为");
        mainTemplateConfig.setLoop(true);

        doGenerator(inputPath, outputPath, mainTemplateConfig);
    }

    /**
     * 使用FreeMarker生成文件
     * @param inputPath 模版文件输入路径
     * @param outputPath 生成文件输出路径
     * @param model 为模板文件准备的数据模型
     * @throws IOException IO异常
     * @throws TemplateException 模板异常
     */
    public static void doGenerator(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        //创建FreeMarker的配置类对象，参数为FreeMarker版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);
        //设置模板文件所在的路径
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);
        //设置模板文件使用的字符编码
        configuration.setDefaultEncoding("utf-8");

        //创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        //指定生成的文件路径和文件名
        FileWriter out = new FileWriter(outputPath);

        //组合处理模板和数据模型，并生成文件
        template.process(model, out);

        //关闭FileWriter流
        out.close();
    }
}
