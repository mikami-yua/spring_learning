package org.example.ba02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
     * 后置通知
     * 1.public方法
     * 2.没有返回值
     * 3.方法名自定义
     * 4.方法有参数,推荐使用object，参数名自定义
     */
    /**
     * @AfterReturning 后置通知
     *      1.value：切入点表达式
     *      2.returning： 自定义变量，表示目标方法的返回值的
     *          自定义的变量名必须和通知方法的形参名一样(returning = "res"和形参名一样即可)
     *      位置：在方法定义的上面
     *
     *      特点
     *          1.在目标方法之后执行
     *          2.可以获取目标方法的返回值，可以根据返回值做不同的处理
     *              object res=doOther（）；
     *              myAfterReturning(Object res)
     *          3.可以修改返回值
     *
     * @param res
     */
    @AfterReturning(value = "execution(public String org.example.ba02.SomeServiceImpl.doOther(String,Integer))",
            returning = "res")
    public void myAfterReturning(Object res){
        //Object res:目标方法的返回值，可以根据返回值做响应的处理
        System.out.println("后置通知"+res);

        //修改返回值------对程序的结果没有影响
        if(res.equals("abcd")){
            res="hello";
        }else {

        }

    }


}
