package com.goncalves.api.enveJ.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class EnveJController {

    @MessageMapping("/socket")
    @SendTo("/topic/messages")
    public String handleInput(String input) {
        System.out.println("Received input: " + input);
        return "Received: " + input;
    }
}
