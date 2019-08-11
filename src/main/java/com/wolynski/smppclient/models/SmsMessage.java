package com.wolynski.smppclient.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class SmsMessage {
    @NonNull
    private String senderNumber;
    @NonNull
    private String receiverNumber;
    @NonNull
    private String message;


}
