package dynamic.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类都必须实现 InvocationHandler 接口
 */
public class InvocationHandlerDemo implements InvocationHandler {
    //要代理的真实对象
    private Object subject;

    public InvocationHandlerDemo(Object subject){
        this.subject = subject;
    }

    /**
     * 通过代理对象调用方法，最终都会被转发为由 invoke 方法进行调用
     *
     * @param proxy 代理的真实对象
     * @param method 所要调用真实对象的某个方法的 Method 对象
     * @param args 所要调用真实对象某个方法时接受的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在代理真实对象的前后都可以扩展其他操作代码
        System.out.println("=========================");
        Object obj = method.invoke(subject, args);
        System.out.println("=========================");
        return obj;
    }
}
