package com.example.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/31
 */
@Component
public class QueueListener {

    @JmsListener(destination = "publish.queue", containerFactory = "jmsListenerContainerQueue")
    @SendTo("out.queue")
    public String receive(String text){
        System.out.println("QueueListener: consumer-a 收到一条信息: " + text);
        return "consumer-a received : " + text;
    }
}
