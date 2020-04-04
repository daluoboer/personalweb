package com.example.demo.proxy;

/**
 * @Description
 * @Author Radish
 * @Date 2020/4/2
 */

public class TestProxy {
    public static void main(String[] args) {
        CGLibProxy proxy = new CGLibProxy();
        AOPService aopService = (AOPService)proxy.getCglibProxy(new AOPServiceImpl());
        aopService.doSomething1();
        System.out.println("\n");
        aopService.doSomething2();

        /*Star ldh = new LiuDeHua();
        StarProxy starProxy = new StarProxy();
        starProxy.setTarget(ldh);
        Object obj = starProxy.createProxyedObj();
        Star star = (Star)obj;

        star.sing("yes");
        star.dance("no");
        star.singAndDance();*/

    }
}
