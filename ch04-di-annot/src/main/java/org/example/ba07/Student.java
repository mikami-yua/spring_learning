package org.example.ba07;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("myStudent")//可以省略value【最常用的方式】

public class Student {
    @Value("李四")
    private String name;
    @Value("20")
    private String age;

    /**
     * 引用类型resource：来自jdk中的注解，spring提供了支持，可以给引用类型赋值
     *      使用的也是自动注入原理：支持byName，byType默认byName
     *  位置在：属性上或set方法上
     */
    //先使用byName自动注入，如果byName再使用byType
    //只使用byName的方法，增加属性name，name的值是bean的id
    @Resource(name = "mySchool")
    private School school;

    public Student() {
        System.out.println("无参数的构造方法");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", school=" + school +
                '}';
    }
}
