package org.example;



import org.example.ba05.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest05 {
    @Test
    public void text01(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        SomeService proxy= (SomeService) ctx.getBean("someService");
        //通过代理的对象执行方法，实现目标方法执行时增强了功能
        /*
        目标类没有接口使用cglib动态代理，spring框架自动应用cglib

        有接口也可以使用cglib的动态代理
         */
        System.out.println("proxy:"+proxy.getClass().getName());
        proxy.doThird();//myAround()
        //System.out.println(str);//hello aspectj AOP
    }

}
