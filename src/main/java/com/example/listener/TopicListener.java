package com.example.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/31
 */
@Component
public class TopicListener {

    @JmsListener(destination = "publish.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive(String text){
        System.out.println("TopicListener: consumer-a 收到一条信息: " + text);
    }
}
