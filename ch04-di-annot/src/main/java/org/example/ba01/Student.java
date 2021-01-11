package org.example.ba01;

import org.springframework.stereotype.Component;

/**
 * Component用于创建对象，等同于bean的功能。
 *      属性：value：对象的名称，相当于bean的id
 *      value是额唯一的。创建的对象在整个spring容器中就一个
 *
 *      位置：在类的上面
 *          @Component(value = "myStudent") 作用等同于bean标签的作用
 *
 * spring中和component作用一致，创建对象的注解还有
 *      1 @Repository（持久层）：放在dao对象上，表示创建dao对象，dao对象可以访问数据库
 *      2 @Service（业务层）：放在service的实现类上面，创建service对象，service对象是业务处理，可以有事物等功能的
 *      3 @Controller（控制器上）：放在控制器上面，创建控制器对象的，接收用户提交的参数，显示请求的处理结果
 *      【以上三个注解的使用语法和Component一样，都能创建对象，但是这三个注解还有额外的功能】
 *       这三个注解是给项目分层的
 *
 * 什么时候用Component
 *      当一个类不是这三层是，但是需要创建对象时（功能不具体时使用）
 *
 */
//@Component(value = "myStudent")
@Component("myStudent")//可以省略value【最常用的方式】

//可以不指定名称，由spring提供默认名称
//@Component//不指定名称时，名字是类名的首字母小写
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
