package org.example;

import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    @Test
    public void test01(){

        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        String names[]=ctx.getBeanDefinitionNames();
        for(String na:names){
            System.out.println("容器中对象的名称："+na);
        }
    }

    @Test
    public void testDaoInsert(){

        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //获取spring中的dao对象
        StudentDao dao= (StudentDao) ctx.getBean("studentDao");
        Student student=new Student();
        student.setId(1014);
        student.setName("夺子姐2");
        student.setAge(4);
        student.setEmail("dddd@bug.com");
        int nums=dao.insertStudent(student);
        System.out.println("nums="+nums);
    }

    @Test
    public void testServiceDao(){

        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //获取service
        StudentService studentService= (StudentService) ctx.getBean("studentService");
        Student student=new Student();
        student.setId(1019);
        student.setName("李博士");
        student.setAge(1);
        student.setEmail("boss@bug.com");
        int nums=studentService.addStudent(student);
        /**
         * spring和mybatis正好在一起时，事务是自动提交的，不需要手动commit
         */
        System.out.println("nums="+nums);
    }

    @Test
    public void testServiceDaoSelect(){

        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //获取service
        StudentService studentService= (StudentService) ctx.getBean("studentService");

        List<Student> students=studentService.queryStudents();

        for(int i=0;i<students.size();i++){
            System.out.println(students.get(i));
        }
    }
}
