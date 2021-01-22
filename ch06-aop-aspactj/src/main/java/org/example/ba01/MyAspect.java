package org.example.ba01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/*
@Aspect:是aspect框架中的注解
    作用是：表明当前类是切面类
        切面类：用来给业务方法增加功能的类，在这个类中有切面的功能代码
    位置：在类的上面
 */
@Aspect
public class MyAspect {
    /**
     * 定义方法，方法实现切面的功能
     * 方法的定义要求
     *  1.public方法
     *  2.没有返回值
     *  3.方法名自定义
     *  4.参数可以有也可以没有
     *      参数不是自定义的
     */
    /**
     * @Before 前置通知
     *      属性value：切入点表达式，表示切面的功能执行的位置
     *      写在：方法的上面
     *      特点：在目标方法之前执行，不改变目标方法*
     */
    //@Before(value = "execution(public void org.example.ba01.SomeServiceImpl.doSome(String,Integer))")//切入点表达式
    /*@Before(value = "execution(void *..SomeServiceImpl.do*(..))")//简写方法  （不匹配时，加不上功能）
    public void myBefore(){
        //方法内是切面的功能
        System.out.println("前置通知，在目标之前执行"+new Date());
    }*/

    /**
     * 指定通知方法中的参数：JoinPoint
     *      JoinPoint代表业务方法（要加入切面功能的方法）
     *      作用：可以在通知方法中获取方法执行的信息，方法的名称，方法从实参
     *          切面功能中需要用到方法的信息，就加入JoinPoint
     *      JoinPoint参数值是框架赋值的，必须是第一个位置的参数
     */
    @Before(value = "execution(void *..SomeServiceImpl.do*(..))")//简写方法  （不匹配时，加不上功能）
    public void myBefore(JoinPoint jp){
        //获取方法的完整定义
        System.out.println("方法签名"+jp.getSignature());
        System.out.println("方法名称"+jp.getSignature().getName());
        //获取实参
        Object args[]=jp.getArgs();
        for(Object arg:args){
            System.out.println(arg);
        }

        //方法内是切面的功能
        System.out.println("前置通知，在目标之前执行"+new Date());
    }
}
