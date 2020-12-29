package org.example;

import org.example.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest02 {
    @Test
    public void test01(){
        String config="ba02/applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);

        //从容器中获取student对象
        Student myStudent= (Student) applicationContext.getBean("myStudent");
        System.out.println(myStudent);

    }

    @Test
    public void test02(){

    }
}
