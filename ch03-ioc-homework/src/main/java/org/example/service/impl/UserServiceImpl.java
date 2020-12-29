package org.example.service.impl;

import org.example.dao.UserDao;
import org.example.domain.SysUser;
import org.example.service.UserService;

public class UserServiceImpl implements UserService {
    //在xml中给属性赋值需要有set方法
    private UserDao dao=null;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void addUser(SysUser user) {
        //调用dao方法
        dao.insertUser(user);
    }
}
