package org.example.ba04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

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
     * 环绕通知方法的定义格式
     *  1.public
     *  2.必须有一个返回值，推荐使用object
     *  3.方法名自定义
     *  4.方法有参数，固定参数 ProceedingJoinPoint
     */

    /**
     * 环绕通知
     * @Around： 环绕通知
     *      属性：value 切入点表达式
     *      位置：在方法定义的上面
     *      特点：
     *          功能最强
     *          在目标方法的前和后都能增强功能
     *          控制目标方法是否被调用执行
     *              当参数是zhangsan时执行增强，不是时只执行增强部分
     *          修改原来方法的执行结果。影响最后的调用结果
     *      环绕通知等于jdk的动态代理，InvocationHandler接口
     *
     * 环绕通知经常做事务，在目标方法之前开启事务，执行方法，目标方法之后提交事务
     *
     * @param pjp 等用于method，作用：执行目标方法的
     * @return 目标方法的结果，可以被修改
     */
    @Around(value = "execution(public void org.example.ba04.SomeServiceImpl.doThird())")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {

        //获取第一个参数的值


        //实现环绕通知
        Object result=null;
        System.out.println("环绕通知在目标方法之前 "+new Date());

        result=pjp.proceed();//等同于：method.invoke();
        System.out.println("环绕通知在目标方法之后  提交事务");


        //返回目标方法的执行结果
        return result;
    }
}
