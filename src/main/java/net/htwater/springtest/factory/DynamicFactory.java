package net.htwater.springtest.factory;

import net.htwater.springtest.dao.UserDao;
import net.htwater.springtest.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
