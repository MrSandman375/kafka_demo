package com.renjie.kafka_demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * @Auther: fan
 * @Date: 2020/11/20
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping(value = "kafkaProducer")
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String ,Object> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
//        Response response = Response.newResponse();
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
        kafkaTemplate.send("Topic-test",gson.toJson(message));
        return  "ok";
    }

    @GetMapping(value = "/sendMessage01")
    public String sendMessage01(){
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
        kafkaTemplate.send("name",gson.toJson(message));
        return  "ok";
    }

}
