package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by v.usov on 28.12.2017.
 */
public class CustomInvocationHandler implements InvocationHandler {

    private SomeInterfaceWithMethods siw;

    public CustomInvocationHandler(SomeInterfaceWithMethods siw) {
        this.siw = siw;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result;

        System.out.println(method.getName() + " in");

        result = method.invoke(siw, args);

        System.out.println(method.getName() + " out");

        return result;
    }
}
