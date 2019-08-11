package com.wolynski.smppclient.controllers;

import com.wolynski.smppclient.models.SmsMessage;
import com.wolynski.smppclient.services.MessageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@Log4j2
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @PostMapping(value = "/send/message",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SmsMessage> getUser(@RequestBody SmsMessage smsMessage) {
        log.info("Send message from sender with number {} to receiver with number {}", smsMessage.getSenderNumber(),
                smsMessage.getReceiverNumber());
        boolean sent = messageService.sendMessage(smsMessage);
        if (sent) {
            log.info("sms was sent");
            return new ResponseEntity<SmsMessage>(HttpStatus.OK);
        }
        else{
            log.warn("sms wasn't sent");
            return new ResponseEntity<SmsMessage>(HttpStatus.BAD_REQUEST);
        }

    }

}
