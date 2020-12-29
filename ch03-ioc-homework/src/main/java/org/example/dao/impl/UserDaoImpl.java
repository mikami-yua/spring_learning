package org.example.dao.impl;

import org.example.dao.UserDao;
import org.example.domain.SysUser;

public class UserDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser user) {
        System.out.println("user插入到mysql数据库");
    }
}
