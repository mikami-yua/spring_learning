package service.impl;

import service.SomeService;
import util.ServiceTools;

import java.util.Date;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {//希望在dosome方法不变的情况下也能有这些额外的功能------动态代理
        //ServiceTools.doLog();//这个代码依然和dosome业务没有关系，还是有破坏
        System.out.println("do some");

        //方法的最后提交一个事务
        //ServiceTools.doTrans();
    }

    @Override
    public void doOther() {
        System.out.println("do other");

    }
}
