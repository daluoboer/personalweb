package com.example.demo.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author Radish
 * @Date 2020/4/2
 */

public class CGLibProxy implements MethodInterceptor {
    private Object target;
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLib动态代理，监听开始！");
        Object invoke = method.invoke(target, objects);
        System.out.println("CGLib动态代理，监听结束！");
        return invoke;
    }

    /*定义获取代理对象方法*/
    public Object getCglibProxy(Object objectTarget) {
        this.target = objectTarget;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(objectTarget.getClass());
        enhancer.setCallback(this);
        Object result = enhancer.create();
        return result;
    }

}
