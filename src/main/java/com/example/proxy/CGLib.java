package com.example.proxy;

/**
 * @Description
 * @Author Radish
 * @Date 2020/4/2
 */

public class CGLib {

    public void something1() {
        System.out.println("I am something1");
        something2();
    }

    public void something2() {
        System.out.println("I am somethiing2");
    }

}
