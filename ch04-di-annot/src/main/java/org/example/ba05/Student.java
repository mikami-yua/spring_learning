package org.example.ba05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
     *      属性：required：是一个boolean类型，默认true
     *          required=true：引用类型赋值失败并终止指向
     *          required=false:引用类型赋值失败，程序正常指向，引用类型赋值为null
     *          【项目开发中使用：使用真更合适，在spring启动的时候可以检测错误。有利于尽早的解决问题。
     *          false可能导致之后出现空指针异常】
     *
     *
     * 位置在：
     *      属性定义的上面，无需set方法，推荐使用【推荐使用】
     *      在set方法的上面
     *
     * 使用byName的方式，需要做的是
     *      1.使用Autowired
     *      2.使用Qualifier（value=“bean的id”）：表示使用指定名称的bean完成赋值
     */
    @Autowired(required = true)
    @Qualifier("mySchool")//告诉spring使用自动注入，使用找名字的方式完成赋值
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
