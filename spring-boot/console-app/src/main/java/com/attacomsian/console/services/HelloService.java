package com.attacomsian.console.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Value("${message.default}")
    private String message;

    public String getMessage() {
        return message;
    }

    public String getMessage(String message) {
        return "Hey, " + message;
    }
}
