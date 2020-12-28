package org.example;

import org.example.service.SomeService;
import org.example.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.util.Date;

public class MyTest {
    @Test
    public void test01(){
        SomeService service=new SomeServiceImpl();
        service.doSome();
    }

    /**
     * 测试spring的使用
     */
    /*
        spring创建对象的时间
        在创建容器对象时，spring会创建配置文件中所有的对象

        spring创建对象默认使用无参构造方法
    */
    @Test
    public void test02(){
        //使用spring容器创建的对象
        //1.指定spring配置文件的名称
        String config="beans.xml";
        //2.创建表示spring容器的对象，ApplicationContext
        //ApplicationContext表示spring容器，通过容器获取对象
        /*
        ClassPathXmlApplicationContext：表示从类路径中加载spring配置文件
        编译之后resource中的配置文件会被拷贝到target的类路径的根目录下
         */
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
        /*
        spring创建对象的时间
        在创建容器对象时，spring会创建配置文件中所有的对象
         */

        //从容器中获取某个对象
        SomeService service=(SomeService) applicationContext.getBean("someService");//配置文件中bean的参数是id，返回一个object对象

        //使用spring创建的对象
        service.doSome();


    }

    /**
     * 获取spring容器中java对象的信息
     */
    @Test
    public void test03(){
        String config="beans.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);

        //使用spring提供的方法，获取容器中定义的对象的数量
        int nums=ac.getBeanDefinitionCount();
        System.out.println(nums);

        //容器中每个定义的对象的名称
        String names[]=ac.getBeanDefinitionNames();
        for(String name:names){
            System.out.println(name);
        }
    }

    /**
     * 获取一个非自定义的类的对象
     */
    @Test
    public void test04(){
        String config="beans.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);

        Date my= (Date) ac.getBean("mydate");
        System.out.println(my);
    }

}
