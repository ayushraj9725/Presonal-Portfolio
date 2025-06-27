package org.portfolio.portfoliobackend.Controller;

import org.portfolio.portfoliobackend.DTO.SendMessageRequestDto;
import org.portfolio.portfoliobackend.DTO.SentMessageResponseDto;
import org.portfolio.portfoliobackend.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/contact")
public class ContactController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/message")
    public ResponseEntity<?> addMessage(@RequestBody SendMessageRequestDto sendMessageRequestDto){

        try{
            SentMessageResponseDto response = messageService.sendMessage(sendMessageRequestDto);

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
