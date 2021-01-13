package handler;

import util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;//目标对象------someserviceimpl类

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 通过代理对象，执行方法时，会调用执行这个invoke方法
     * 实现增加功能
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行了invoke方法");
        System.out.println("方法名"+method.getName());
        String methodName=method.getName();
        Object res=null;
        if("doSome".equals(methodName)){//通过if判断可以控制哪些方法增加功能，哪些方法不增加功能
            //执行目标类的方法，通过method方法实现
            ServiceTools.doLog();
            res=method.invoke(target,args);//执行someserviceimpl。dosome
            ServiceTools.doTrans();
        }else {
            res=method.invoke(target,args);//执行someserviceimpl。dosome
        }



        return res;//返回目标方法执行结果
    }
}
