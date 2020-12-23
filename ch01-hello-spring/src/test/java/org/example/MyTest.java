package org.example;

import org.example.service.SomeService;
import org.example.service.impl.SomeServiceImpl;
import org.junit.Test;

public class MyTest {
    @Test
    public void test01(){
        SomeService service=new SomeServiceImpl();
        service.doSome();
    }

}
