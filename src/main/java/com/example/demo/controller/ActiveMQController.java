package com.example.demo.controller;

import com.example.demo.test.SpringTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @Description
 * @Author Radish
 * @Date 2020/3/31
 */

@RestController
public class ActiveMQController {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private SpringTask springTask;
    @RequestMapping("/sendMsg")
    public void sendMsg(String msg) {
        jmsTemplate.send("q2", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {

                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(msg);
                return textMessage;
            }
        });
    }

    @RequestMapping("task1")
    public void task1() {
        springTask.task1();
    }

    @RequestMapping(value = "task2")
    public void task2() {
        springTask.task2();
    }
}
