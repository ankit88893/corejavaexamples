package com.dxctraining.senderapp;

import com.dxctraining.shared.DxcMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/messages")
@RestController
public class MessageController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/add/mp")
    public String sendForMp(@RequestBody DxcMessage message){
       jmsTemplate.convertAndSend("mp",message);
       return "msg sent for consumption";
    }

    @PostMapping("/add/telangana")
    public String sendForTelanagna(@RequestBody DxcMessage message){
        jmsTemplate.convertAndSend("telangana",message);
        return "msg sent for consumption";

    }

    @PostMapping("/add/ap")
    public String sendForAndhra(@RequestBody DxcMessage message){
        jmsTemplate.convertAndSend("andhra",message);
        return "msg sent for consumption";
    }


}
