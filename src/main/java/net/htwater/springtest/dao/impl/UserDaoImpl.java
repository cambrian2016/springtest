package net.htwater.springtest.dao.impl;

import net.htwater.springtest.dao.UserDao;
import net.htwater.springtest.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    private String userName;
    private int age;
    private List<String> strList;
    private Map<String, User> userMap;
    private Properties properties;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建。。。");
    }

    public void init(){
        System.out.println("UserDaoImpl初始化方法");
    }

    public void destroy(){
        System.out.println("UserDaoImpl销毁方法");
    }

    @Override
    public void save() {
        System.out.println(userName+"======"+age);
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);

        System.out.println("UserDaoImpl save running...");
    }
}
