package com.example.demo.proxy;

/**
 * @Description
 * @Author Radish
 * @Date 2020/4/2
 */

public class AOPServiceImpl implements AOPService {
    @Override
    public void doSomething1() {
        System.out.println("I am doSomething1");
        doSomething2();
    }

    @Override
    public void doSomething2() {
        System.out.println("I am doSomething2");
    }
}
