package com.xiaopengwei.springboot.rabbitmq.rabbit.topic;import org.springframework.amqp.rabbit.annotation.RabbitHandler;import org.springframework.amqp.rabbit.annotation.RabbitListener;import org.springframework.stereotype.Component;/** * <p> * TopicReceiver2 * </p> * * @author github.com/xpwi * @since 2019-04-20 */@Component@RabbitListener(queues = "topic.messages")public class TopicReceiver2 {    @RabbitHandler    public void process(String message) {        System.out.println("Topic Receiver2  : " + message);    }}