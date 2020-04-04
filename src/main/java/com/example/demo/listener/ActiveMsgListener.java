package com.example.demo.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/31
 */

@Service
public class ActiveMsgListener {
    @JmsListener(destination = "q2")
    public void rctiveMsg(String message){
        System.out.println("------监听到activemq的数据"+message);
    }
}
