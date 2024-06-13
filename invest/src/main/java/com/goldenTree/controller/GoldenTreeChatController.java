package com.goldenTree.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.goldenTree.dto.ChatMessage;

@Controller
public class GoldenTreeChatController {

    @GetMapping("/chatRoom")
    public String chat(Model model) {
        return "chatRoom";
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return chatMessage;
    }
    
    @GetMapping("/GoldenTreeRoom")
    public String GoldenTree(Model model) {
        return "chatRoom2";
    }
}
