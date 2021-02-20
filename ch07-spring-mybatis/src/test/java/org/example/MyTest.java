package org.example;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test01(){

        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        String names[]=ctx.getBeanDefinitionNames();
        for(String na:names){
            System.out.println("容器中对象的名称："+na);
        }
    }
}
