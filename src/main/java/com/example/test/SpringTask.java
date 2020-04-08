package com.example.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Radish
 * @Date 2020/4/3
 */
@Component
public class SpringTask {
    private static final Logger logger = LoggerFactory.getLogger(SpringTask.class);

    @Scheduled(cron = "1/5 * * * * *")
    public void task1() {
        logger.info("SpringTask定时任务Task1");
    }

    @Scheduled(initialDelay = 1000,fixedRate = 2*1000)
    public void task2() {
        logger.info("SpringTask定时任务Task2");
    }
}
