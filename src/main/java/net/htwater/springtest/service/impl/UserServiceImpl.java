package net.htwater.springtest.service.impl;

import net.htwater.springtest.dao.UserDao;
import net.htwater.springtest.dao.impl.UserDaoImpl;
import net.htwater.springtest.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }


    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
