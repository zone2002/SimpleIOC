package org.example.dao.impl;

import org.example.dao.StuDao;

public class StuDaoImplA implements StuDao {
    public String findById(Long id) {
        return "Dao层A实现被调用, 查询到学生:Tom";
    }
}
