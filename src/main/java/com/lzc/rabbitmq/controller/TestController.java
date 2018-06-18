package com.lzc.rabbitmq.controller;

import com.lzc.rabbitmq.config.DelaySender;
import com.lzc.rabbitmq.config.Sender;
import com.lzc.rabbitmq.dataobject.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.DelayQueue;

@RestController
public class TestController {

    @Autowired
    private Sender sender;

    @Autowired
    private DelaySender delaySender;

    @GetMapping("/sendDirectQueue")
    public Object sendDirectQueue() {
        sender.sendDirectQueue();
        return "ok";
    }

    @GetMapping("/sendTopic")
    public Object sendTopic() {
        sender.sendTopic();
        return "ok";
    }

    @GetMapping("/sendFanout")
    public Object sendFanout() {
        sender.sendFanout();
        return "ok";
    }

    @GetMapping("/sendDelay")
    public Object sendDelay() {
        Order order1 = new Order();
        order1.setOrderStatus(0);
        order1.setOrderId("123456");
        order1.setOrderName("小米6");

        Order order2 = new Order();
        order2.setOrderStatus(1);
        order2.setOrderId("456789");
        order2.setOrderName("小米8");

        delaySender.sendDelay(order1);
        delaySender.sendDelay(order2);
        return "ok";
    }
}
