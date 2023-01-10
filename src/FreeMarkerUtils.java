import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.collections.map.HashedMap;

import java.io.*;
import java.util.*;

public class FreeMarkerUtils {
    //模板配置对象
    private Configuration cfg;
    //Yaml目录
    private static String yamlPath = "resources\\yaml";

    /**
     * 初始化配置
     */
    public void init() {
        cfg = new Configuration();
        cfg.setDefaultEncoding("utf-8");
        cfg.setClassForTemplateLoading(this.getClass(), "/resources");
    }

    public void process(Map<String, Object> map){
        try {
            Template template = cfg.getTemplate("yaml.ftl");
            template.process(map, new FileWriter(new File("d:/test.yaml")));
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
//        FreeMarkerUtils test = new FreeMarkerUtils();
//        test.init();
//
//        //生成一个pod的yaml文件
//        Map<String,Object> podMap = new HashMap<String,Object>();
//        podMap.put("name", "namename");
//        podMap.put("key", "keykey");
//        podMap.put("role", "AE");
//
//        test.process(podMap);

        run();
    }

    public static void run() throws Exception{
        InputStreamReader fren = new InputStreamReader(new FileInputStream("C:\\Users\\Lenovo\\Desktop\\role.txt"), "UTF-8");
        BufferedReader bfen = new BufferedReader(fren);
        FreeMarkerUtils test = new FreeMarkerUtils();
        test.init();
        String stren = null;
        Map<String,Object> map = new HashedMap();
        List<Map<String,Object>> permissionList = new ArrayList();
        List<String> roles = Arrays.asList("Sales FA B3 Online");
        while ((stren = bfen.readLine()) != null) {
            System.out.println(stren);
            String[] strarr = stren.split(",");
            Map<String,Object> podMap = new HashMap<>();
            podMap.put("name", strarr[1]);
            podMap.put("key", strarr[0]);
            podMap.put("roleList", roles);
            permissionList.add(podMap);
        }
        map.put("permissionList",permissionList);
        test.process(map);
    }

}
