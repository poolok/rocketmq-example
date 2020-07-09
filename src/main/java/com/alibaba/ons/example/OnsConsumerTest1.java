package com.alibaba.ons.example;

import com.aliyun.openservices.ons.api.*;

import java.util.Properties;

/**
 * 创建: rocketmq-example
 * 描述:
 * 编写者:农剑斌<nong-juan@163.com>
 * 版本: 0.0.1
 * 创建时间:15-12-17 下午5:45
 */
public class OnsConsumerTest1 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ConsumerId, "");
        properties.put(PropertyKeyConst.AccessKey, "");
        properties.put(PropertyKeyConst.SecretKey, "");
        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe("MyTest1", "*", new MessageListener() {
            public Action consume(Message message, ConsumeContext context) {
                System.out.println("Receive: " + message);
                return Action.CommitMessage;
            }
        });
        consumer.start();
        System.out.println("Consumer Started");
    }
}
