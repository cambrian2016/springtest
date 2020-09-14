package net.htwater.springtest.factory;

import net.htwater.springtest.dao.UserDao;
import net.htwater.springtest.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
