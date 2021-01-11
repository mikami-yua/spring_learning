package org.example.ba03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myStudent")//可以省略value【最常用的方式】

public class Student {
    @Value("李四")
    private String name;
    @Value("20")
    private String age;

    /**
     * 引用类型
     * @Autowired:spring提供的注解，实现给引用类型赋值
     * spring给引用类型赋值使用的是自动注入原则，支持byName，byType
     * Autowired默认使用byType
     *
     * 位置在：
     *      属性定义的上面，无需set方法，推荐使用【推荐使用】
     *      在set方法的上面
     *
     * 使用自动注入需要找一个同源对象，在当前包中没有school的同源对象（配置文件中没有school对象，也没有使用注解生成对象），
     * 需要school对象，需要使用注解生成一个对象
     * 使用bean标签也行，只要能创建对象就行
     */
    @Autowired
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
