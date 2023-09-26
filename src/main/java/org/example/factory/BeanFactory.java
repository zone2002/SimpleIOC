package org.example.factory;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean工厂
 */
public class BeanFactory {
    private static final Properties properties;
    private static final Map<String, Object> cache = new ConcurrentHashMap<>();
    static {
        properties = new Properties();
        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("factory.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Object getBean(String beanName){
        Object obj = cache.get(beanName);
        //判断缓存中有无bean
        if(obj == null){
            //保证线程安全
            synchronized (BeanFactory.class){
                //获取全类名
                String value = properties.getProperty(beanName);
//                    System.out.println(value);
                //利用反射创建对象
                Class<?> clazz;
                try {
                    clazz = Class.forName(value);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                try {
                    obj = clazz.getConstructor().newInstance();
                } catch (InstantiationException
                         | IllegalAccessException
                         | InvocationTargetException
                         | NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
                cache.put(beanName, obj);
            }
        }
        return obj;
    }
}
