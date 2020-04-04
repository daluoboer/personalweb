package com.example.demo.test;

import com.example.demo.proxy.AOPService;
import com.example.demo.proxy.AOPServiceImpl;
import com.example.demo.proxy.AOPServiceProxy;

/**
 * @Description
 * @Author Radish
 * @Date 2020/4/2
 */

public class AOPTest {
    public static void main(String[] args) {
        AOPService aopService = new AOPServiceImpl();
        AOPServiceProxy aopServiceProxy = new AOPServiceProxy();
        aopServiceProxy.setAopService(aopService);

        AOPService aop = (AOPService)aopServiceProxy;
        aop.doSomething2();
        System.out.println("\n");
        aop.doSomething1();
    }
}
