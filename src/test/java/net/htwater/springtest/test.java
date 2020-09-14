package net.htwater.springtest;

import net.htwater.springtest.dao.UserDao;
import net.htwater.springtest.util.Calculator;
import net.htwater.springtest.util.Person;
import net.htwater.springtest.util.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Properties;

@SuppressWarnings("all")
public class test {

    @Before
    public void init() {
        System.out.println("init ============= ");
    }

    @After
    public void close() {
        System.out.println("close ============");
    }

    @Test
    //测试Scope属性
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) applicationContext.getBean("userDao");
        UserDao userDao2 = (UserDao) applicationContext.getBean("userDao");

        System.out.println(userDao1);
        System.out.println(userDao2);
    }


    @Test
    /**
     * 类  名：
     * 描  述：
     * <p>
     * 功能一：
     * @param
     * @author ShenHaiyun no.HT151 软件部移动组
     * @date
     */
    public void testAdd() {
        System.out.println("我被执行了add");

        try {
            Properties properties = new Properties();

            ClassLoader classLoader = test.class.getClassLoader();

            InputStream inputStream = classLoader.getResourceAsStream("pro.properties");
            properties.load(inputStream);
            String className = properties.getProperty("className");
            String methodName = properties.getProperty("methodName");

            Class mClass = Class.forName(className);
            Method method = mClass.getDeclaredMethod(methodName);
            method.invoke(mClass.newInstance());

        } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        } finally {

        }
    }



    @Test
    public void testSub() {
        System.out.println("我被执行了sub");

        Person person=new Person();
        person.eat();
        new Date();
    }



}
