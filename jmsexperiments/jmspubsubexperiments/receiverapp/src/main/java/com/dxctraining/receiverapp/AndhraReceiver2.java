package com.dxctraining.receiverapp;

import com.dxctraining.shared.DxcMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AndhraReceiver2 {

    @JmsListener(destination = "india.andhra", containerFactory = "listenerFactory")
    public void receiveTelaganaMessage(DxcMessage received) {
        System.out.println("***********inside Andhra pradesh receiver 2 Welcome in andhra="+received.getReceiver()
               + "message is"+ received.getMessage()    );
    }
}
