package net.htwater.springtest.demo;

import net.htwater.springtest.service.UserService;
import net.htwater.springtest.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("C:\\workspace_javaee\\springtest\\src\\main\\resources\\applicationContext.xml");
//        UserService userService= (UserService) applicationContext.getBean("userService");
        UserService userService= (UserService) applicationContext.getBean(UserService.class);
        userService.save();
    }
}
