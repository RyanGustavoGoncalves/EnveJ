package com.goncalves.api.enveJ.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enveJ")
public class EnveJController {

    @MessageMapping("/socket")
    @SendTo("/topic/messages")
    public String handleInput(String input) {
        System.out.println("Received input: " + input);
        return "Received: " + input;
    }
}
