package org.example.dao.impl;

import org.example.dao.UserDao;
import org.example.domain.SysUser;

public class OracleDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser user) {
        System.out.println("oracle的insert");
    }
}
