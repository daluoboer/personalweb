package com.example.proxy;

/**
 * @Description
 * @Author Radish
 * @Date 2020/4/2
 */

public class AOPServiceProxy implements AOPService {
    private AOPService aopService;
    public void setAopService(AOPService aopService) {
        this.aopService = aopService;
    }
    @Override
    public void doSomething1() {
        before();
        aopService.doSomething1();
        after();
    }

    @Override
    public void doSomething2() {
        before();
        aopService.doSomething2();
        after();
    }

    @Override
    public void doSomething3() {
        before();
        aopService.doSomething3();
        after();
    }

    public void before() {
        System.out.println("Proxy before...");
    }

    public void after() {
        System.out.println("Proxy after...");
    }
}
