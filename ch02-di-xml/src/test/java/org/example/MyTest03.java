package org.example;

import org.example.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class MyTest03 {
    @Test
    public void test01(){
        String config="ba03/applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);

        //从容器中获取student对象
        Student myStudent= (Student) applicationContext.getBean("myStudent");
        System.out.println(myStudent);

    }

    @Test
    public void test02(){
        String config="ba03/applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);

        //从容器中获取student对象
        Student myStudent= (Student) applicationContext.getBean("myStudent2");
        System.out.println(myStudent);
    }

    @Test
    public void test03(){
        String config="ba03/applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);

        //从容器中获取student对象
        Student myStudent= (Student) applicationContext.getBean("myStudent3");
        System.out.println(myStudent);
    }

    @Test
    public void test04(){
        String config="ba03/applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);

        //从容器中获取student对象
        File myf= (File) applicationContext.getBean("myfile");
        System.out.println(myf.getName());
    }
}
