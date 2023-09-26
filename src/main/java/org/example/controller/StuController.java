package org.example.controller;

import org.example.factory.BeanFactory;
import org.example.service.StuService;

public class StuController {
    private final StuService stuService = (StuService) BeanFactory.getBean("StuService");
    public String findStu(Long id){
        System.out.println("controller层被调用...");
        return stuService.findById(id);
    }
}
