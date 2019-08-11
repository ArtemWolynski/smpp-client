package com.wolynski.smppclient.services;

import com.wolynski.smppclient.models.SmsMessage;

public interface MessageService {
    boolean sendMessage(SmsMessage smsMessage);
}
