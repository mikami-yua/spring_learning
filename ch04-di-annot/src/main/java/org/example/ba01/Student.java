package org.example.ba01;

import org.springframework.stereotype.Component;

/**
 * Component用于创建对象，等同于bean的功能。
 *      属性：value：对象的名称，相当于bean的id
 *      value是额唯一的。创建的对象在整个spring容器中就一个
 *
 *      位置：在类的上面
 *          @Component(value = "myStudent") 作用等同于bean标签的作用
 */
@Component(value = "myStudent")
public class Student {
    private String name;
    private String age;

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
                '}';
    }
}
