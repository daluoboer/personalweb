package com.example.proxy;

/**
 * @Description
 * @Author Radish
 * @Date 2020/4/2
 */

public class LiuDeHua implements Star {
    @Override
    public String sing(String name) {
        System.out.println("给我一杯忘情水");
        return "唱完";
    }

    @Override
    public String dance(String name) {
        System.out.println("开心的马驹");
        return "跳完";
    }

    @Override
    public void singAndDance() {
        sing("1");
        dance("2");
    }
}
