package org.example.ba01;

//目标类
public class SomeServiceImpl implements SomeService {
    /**
     * 目标是给dosome增加功能
     * @param name
     * @param age
     */
    @Override
    public void doSome(String name,Integer age) {
        //在dosome执行之前输出执行的时间
        System.out.println("目标方法dosome");
    }
}
