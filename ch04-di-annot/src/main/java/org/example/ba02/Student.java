package org.example.ba02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("myStudent")//可以省略value【最常用的方式】

public class Student {
    /**
     *  @value：简单类型的属性赋值
     *      属性：value是String类型的，表示简单类型的属性值
     *      位置：1 在属性定义的上面，无需set方法【推荐使用】
     *            2 在set方法上面
     */
    @Value("张飞")
    private String name;

    private String age;

    public Student() {
        System.out.println("无参数的构造方法");
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
    @Value("30")
    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
