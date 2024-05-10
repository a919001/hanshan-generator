import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FreeMarker测试
 */
public class FreeMarkerTest {

    @Test
    public void test() throws IOException, TemplateException {
        //创建FreeMarker的配置类对象，参数为FreeMarker版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);
        //设置模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        //设置模板文件使用的字符编码
        configuration.setDefaultEncoding("utf-8");

        //创建模板对象，加载指定模板
        Template template = configuration.getTemplate("myweb.html.ftl");

        //创建数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear", 2024);
        List<Map<String, Object>> menuItems = new ArrayList<>();
        Map<String, Object> item1 = new HashMap<>();
        item1.put("url", "https://www.hanshan.com");
        item1.put("label", "山寒与茶");
        Map<String, Object> item2 = new HashMap<>();
        item2.put("url", "https://www.houyin.com");
        item2.put("label", "侯音雨柔");
        menuItems.add(item1);
        menuItems.add(item2);
        dataModel.put("menuItems", menuItems);

        //指定生成的文件路径和文件名
        FileWriter out = new FileWriter("myweb.html");

        //组合处理模板和数据模型，并生成文件
        template.process(dataModel, out);

        //关闭FileWriter流
        out.close();
    }
}
