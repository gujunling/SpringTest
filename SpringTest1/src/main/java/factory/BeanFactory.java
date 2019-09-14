package factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 用于创建bean对象的工厂
 *
 * @author gjq
 * @create 2019-09-02-13:53
 */
public class BeanFactory {

    //定义一个properties对象
    private static Properties props;

    //定义一个Map，用于存放我们要创建的对象，称为容器。
    private static Map<String , Object> beans;


    //使用静态代码块为properties对象赋值

    static {

        try {
            //实例化对象
            props = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration<Object> keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每一个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("properties初始化异常");
        }
    }


    /**
     * 根据bean的名称获取bean对象
     *
     * @param beanName
     * @return
     */
   /* public static Object getBean(String beanName) {

        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/
    public static Object getBean(String beanName) {

        return beans.get(beanName);
    }


}
