package com.example.opgavemessageendpoint.controller;

import com.example.opgavemessageendpoint.model.Message;
import com.example.opgavemessageendpoint.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("message")
// Controller-klassen håndterer HTTP-anmodninger fra klienten.
// Den bruger @Controller i stedet for @RestController og returnerer data via ResponseEntity.
public class MessageController {
    private final MessageService service;

    public MessageController(MessageService messageService) {
        this.service = messageService;
    }

    @GetMapping()
    public ResponseEntity<List<Message>> getMessages() {
        List<Message> messages = service.getMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Message> addmessage(@RequestBody Message message){
        Message newMessage = service.addMessage(message);
        return new ResponseEntity<>(newMessage, HttpStatus.CREATED);
    }
}