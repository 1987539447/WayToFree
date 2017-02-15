package com.github.siemen.component;

import com.github.siemen.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Zhan on 2017/2/13 0013.
 */
@Component
public class MessagePrinter {
    private final MessageService service;

    @Autowired
    public MessagePrinter(MessageService servcie){
        this.service = servcie;
    }

    public void printMessage(){
        System.out.println(this.service.getMessage());
    }
}
