package org.example;

import org.example.ba03.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest03 {
    @Test
    public void text01(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        SomeService proxy= (SomeService) ctx.getBean("someService");
        //通过代理的对象执行方法，实现目标方法执行时增强了功能
        String str=proxy.doFirst("zhangsan",80);//myAround()
        System.out.println(str);//hello aspectj AOP
    }

}
