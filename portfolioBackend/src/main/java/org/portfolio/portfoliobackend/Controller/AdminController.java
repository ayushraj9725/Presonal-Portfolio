package org.portfolio.portfoliobackend.Controller;

import org.portfolio.portfoliobackend.Model.ContactMessage;
import org.portfolio.portfoliobackend.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/messages")
    public ResponseEntity<List<ContactMessage>> getAllContacts(){
        try{
            List<ContactMessage> messages = messageService.getAllMessages();
            return new ResponseEntity<>(messages, HttpStatus.OK);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("message/{messageId}")
    public ResponseEntity<?> getMessageById(@PathVariable Long messageId){
        try{
            Optional<ContactMessage> message = this.messageService.getMessageById(messageId);
            return new ResponseEntity<>(message.get(),HttpStatus.OK);

        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("message/{messageId}")
    public ResponseEntity<?> deleteMessageById(@PathVariable Long messageId){
        try{
            boolean isDeleted = this.messageService.deleteMessageById(messageId);
            if(isDeleted){
                return new ResponseEntity<>("unable to delete review on " + messageId , HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>("Delete Review Successfully ",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
