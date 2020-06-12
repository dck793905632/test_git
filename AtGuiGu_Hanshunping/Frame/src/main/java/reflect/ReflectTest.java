package reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //1 加载配置文件
        //1.1创建properties对象
        Properties pro = new Properties();
        //1.2加载配置文件，转换为一个集合
        //1.2.1获得class目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("pro.properties");
        pro.load(inputStream);

        //2,获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        System.out.println(className+" "+methodName);

        //3，记载该类进内存
        Class<?> cls = Class.forName(className);
        //4 创建对象
        Object obj = cls.newInstance();
        // 5 获取方法对象
        Method method = cls.getMethod(methodName);
        //6 执行方法
        method.invoke(obj);
    }
}
