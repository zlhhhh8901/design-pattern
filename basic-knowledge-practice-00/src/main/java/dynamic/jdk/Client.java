package dynamic.jdk;

import dynamic.jdk.proxy.InvocationHandlerDemo;
import dynamic.jdk.subject.RealSubject;
import dynamic.jdk.subject.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        //真实对象
        RealSubject realSubject = new RealSubject();
        //构建代理对象所需要传入的第三个参数
        InvocationHandler handler = new InvocationHandlerDemo(realSubject);
        /**
         * 通过 Proxy 类的 newProxyInstance 方法来创建代理对象，需要传入三个参数：
         * 第一个参数是类加载器，这里使用 handler 这个类的加载器来加载代理对象
         * 第二个参数是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        Subject proxyInstance = (Subject) Proxy.newProxyInstance(
                handler.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),
                handler);
        /**
         * 通过代理对象调用方法
         * 程序就会跳转到由这个代理对象关联到的 handler 中的 invoke 方法去执行
         * 而我们的这个 handler 对象又接受了一个 RealSubject 类型的参数
         * 其内部是通过反射调用 RealSubject 对应的方法实现
         */
        proxyInstance.hello("World");
        System.out.println(proxyInstance.getClass().getName());
        System.out.println(proxyInstance.bye());
    }
}
