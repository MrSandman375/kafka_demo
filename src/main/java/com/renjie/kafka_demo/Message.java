package com.renjie.kafka_demo;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: fan
 * @Date: 2020/11/20
 * @Description:
 */
@Data
public class Message {
    private Long id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳

}
