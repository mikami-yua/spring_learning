package org.example;



import org.example.ba04.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest04 {
    @Test
    public void text01(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        SomeServiceImpl proxy= (SomeServiceImpl) ctx.getBean("someService");
        //通过代理的对象执行方法，实现目标方法执行时增强了功能
        /*
        目标类没有接口使用cglib动态代理，spring框架自动应用cglib
         */
        System.out.println("proxy:"+proxy.getClass().getName());//proxy:org.example.ba04.SomeServiceImpl$$EnhancerBySpringCGLIB$$8121db92
        proxy.doThird();//myAround()
        //System.out.println(str);//hello aspectj AOP
    }

}
