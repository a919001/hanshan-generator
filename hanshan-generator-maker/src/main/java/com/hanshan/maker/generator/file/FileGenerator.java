package com.hanshan.maker.generator.file;

import com.hanshan.maker.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 */
public class FileGenerator {

    public static void main(String[] args) throws TemplateException, IOException {
        //数据模型
        DataModel dataModel = new DataModel();
        dataModel.setAuthor("侯音");
        dataModel.setOutputText("输出结果为");
        dataModel.setLoop(true);

        doGenerate(dataModel);
    }

    public static void doGenerate(Object model) throws IOException, TemplateException {
    /*
        静态文件生成
    */
        //当前项目的根目录
        String propertyPath = System.getProperty("user.dir");
        //输入路径
        String staticInputPath = propertyPath + File.separator + "hanshan-generator-demo-projects" + File.separator + "acm-template";
        //输出路径
        String staticOutputPath = propertyPath;
        //复制
        StaticFileGenerator.copyFileByHutool(staticInputPath, staticOutputPath);

        /*
            动态文件生成
        */
        //设置模板文件所在的路径
        String projectPath = propertyPath + File.separator + "hanshan-generator-maker";
        String dynamicInputPath = projectPath + "/src/main/resources/templates/MainTemplate.java.ftl";

        //生成文件输出路径
        String dynamicOutputPath = staticOutputPath + File.separator + "acm-template/src/com/hanshan/acm/MainTemplate.java";

        DynamicFileGenerator.doGenerator(dynamicInputPath, dynamicOutputPath, model);
    }
}
