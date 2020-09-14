package net.htwater.springtest;

import net.htwater.springtest.dao.UserDao;
import net.htwater.springtest.util.Calculator;
import net.htwater.springtest.util.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Before
    public void init(){
        System.out.println("init ============= ");
    }

    @After
    public void close(){
        System.out.println("close ============");
    }

    @Test
    //测试Scope属性
    public void test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1= (UserDao) applicationContext.getBean("userDao");
        UserDao userDao2= (UserDao) applicationContext.getBean("userDao");

        System.out.println(userDao1);
        System.out.println(userDao2);
    }


    @Test
    public void testAdd(){
        System.out.println("我被执行了add");

        try {
            Class mClass1= Class.forName("net.htwater.springtest.util.Person");
            System.out.println(mClass1);

            System.out.println(mClass1.getFields());
            System.out.println(mClass1.getDeclaredFields());
            System.out.println(mClass1.getConstructors());
            System.out.println(mClass1.getMethods());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//
//        Calculator calculator=new Calculator();
//        int result=calculator.add(1,2);
//
//        Assert.assertEquals(3,result);
    }

    @Test
    public void testSub(){
        System.out.println("我被执行了sub");
        Calculator calculator=new Calculator();
        int result=calculator.sub(1,2);

        Assert.assertEquals(-1,result);
    }
}
