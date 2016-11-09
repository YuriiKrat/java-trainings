package ua.training;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Yurii Krat
 * @version 1.0, 09.11.16
 */
public class MyProxy implements InvocationHandler {

    private final Object obj;

    public MyProxy(Object obj) {
        this.obj = obj;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("get")) {
            System.out.println("Invoking of method " + method.getName() + " from Proxy");
            return method.invoke(obj, args);
        }
        else {
            throw new UnsupportedOperationException("Try to invoke non-get method!");
        }
    }
}
