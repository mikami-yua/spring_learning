package util;

import java.util.Date;

public class ServiceTools {
    public static void doLog(){
        System.out.println("执行时间"+new Date());//与业务逻辑无关是个非业务方法
    }

    public static void doTrans(){
        System.out.println("提交事务");
    }
}
