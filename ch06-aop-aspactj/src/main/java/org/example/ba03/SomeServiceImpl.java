package org.example.ba03;

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

    /**
     * 在目标方法之后模拟提交事务
     * @param name
     * @param age
     * @return
     */
    @Override
    public String doOther(String name, Integer age) {
        System.out.println("目标方法doother");
        return "abcd";
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("====业务方法doFirst（）====");
        return "doFirst";
    }
}
