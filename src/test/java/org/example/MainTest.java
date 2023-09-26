package org.example;

import org.example.controller.StuController;
import org.example.factory.BeanFactory;
import org.junit.Test;

public class MainTest {
    /**
     * 测试是否可行
     */
    @Test
    public void mainTest(){
        StuController stuController = (StuController) BeanFactory.getBean("StuController");
        System.out.println(stuController.findStu(null));//返回值是写死的，不需要传参
    }

    /**
     * 测试创建出的对象是否是单例的
     */
    @Test
    public void singleTest(){
        for (int i = 0; i < 10; i++) {
            System.out.println(BeanFactory.getBean("StuController"));
        }
    }
}
