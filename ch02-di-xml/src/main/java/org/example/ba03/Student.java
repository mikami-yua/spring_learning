package org.example.ba03;

public class Student {

    private String name;
    private int age;

    //声明一个引用类型
    private School school;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    /**
     * 有参数的构造方法
     * @param name
     * @param age
     * @param school
     */
    public Student(String name, int age, School school) {
        System.out.println("=======student有参数的构造方法=======");
        this.name = name;
        this.age = age;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
