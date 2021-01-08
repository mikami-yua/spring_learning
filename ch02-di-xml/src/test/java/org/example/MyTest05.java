package org.example;

import org.example.ba05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest05 {
    @Test
    public void test01(){
        String config="ba05/applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);

        //从容器中获取student对象
        Student myStudent= (Student) applicationContext.getBean("myStudent");
        System.out.println(myStudent);

    }

    @Test
    public void test02(){

    }
}
