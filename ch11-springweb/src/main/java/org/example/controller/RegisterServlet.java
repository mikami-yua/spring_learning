package org.example.controller;

import org.example.domain.Student;
import org.example.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String strId=request.getParameter("id");
        String strName=request.getParameter("name");
        String strEmail=request.getParameter("email");
        String strAge=request.getParameter("age");

        //创建spring容器对象
        //String config="applicationContext.xml";
        //ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        WebApplicationContext ctx=null;
        //获取servletContext种的容器对像
        /*String key=WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        Object attr= getServletContext().getAttribute(key);
        if (attr != null) {
            ctx= (WebApplicationContext) attr;
        }*/

        //使用框架种的方法获取容器对象
        ServletContext sc=getServletContext();
        WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
        System.out.println("容器对象的信息"+ctx);




        //获取service
        StudentService service= (StudentService) ctx.getBean("studentService");
        Student student=new Student();
        student.setId(Integer.parseInt(strId));
        student.setName(strName);
        student.setEmail(strEmail);
        student.setAge(Integer.valueOf(strAge));
        service.addStudent(student);

        //给一个页面
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
