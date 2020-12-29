package org.example;

import org.example.domain.SysUser;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        String config="applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        UserService service= (UserService) ac.getBean("userService2");
        SysUser user=new SysUser();
        user.setName("lisi");
        user.setAge(20);
        service.addUser(user);
    }
}
