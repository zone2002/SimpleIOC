package org.example.service.impl;

import org.example.dao.StuDao;
import org.example.factory.BeanFactory;
import org.example.service.StuService;


public class StuServiceImpl implements StuService {
    private final StuDao stuDao = (StuDao) BeanFactory.getBean("StuDao");

    @Override
    public String findById(Long id) {
        System.out.println("service层被调用...");
        return stuDao.findById(id);
    }
}
