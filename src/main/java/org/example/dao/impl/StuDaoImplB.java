package org.example.dao.impl;

import org.example.dao.StuDao;

public class StuDaoImplB implements StuDao {
    @Override
    public String findById(Long id) {
        return "Dao层B实现被调用, 查询到学生:Bob";
    }
}
