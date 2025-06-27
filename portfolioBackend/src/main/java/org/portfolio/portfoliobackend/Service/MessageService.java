package org.portfolio.portfoliobackend.Service;

import jakarta.persistence.EntityNotFoundException;
import org.hibernate.FetchNotFoundException;
import org.portfolio.portfoliobackend.DTO.SendMessageRequestDto;
import org.portfolio.portfoliobackend.DTO.SentMessageResponseDto;
import org.portfolio.portfoliobackend.Model.ContactMessage;
import org.portfolio.portfoliobackend.Repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    public SentMessageResponseDto sendMessage(SendMessageRequestDto sendMessageRequestDto){

        ContactMessage contactMessage = ContactMessage.builder()
                .name(sendMessageRequestDto.getName())
                .email(sendMessageRequestDto.getEmail())
                .message(sendMessageRequestDto.getMessage())
                .build();

        ContactMessage sentDetails = contactMessageRepository.save(contactMessage);

        return SentMessageResponseDto.fromSentMessageResponseDto(sentDetails);

    }

    // method for getting all the messages by admin

    public List<ContactMessage> getAllMessages(){
        return this.contactMessageRepository.findAll();
    }


    // method for getting a message by id

    public Optional<ContactMessage> getMessageById(Long Id) throws EntityNotFoundException {
        Optional<ContactMessage> message;

        try {
            message = this.contactMessageRepository.findById(Id);
            if (message.isEmpty()) {
                throw new EntityNotFoundException("Review with id " + Id + " not found");
            }

        }catch (Exception e){
            e.printStackTrace();
            if(e.getClass() == EntityNotFoundException.class){
                throw new FetchNotFoundException("Review with id " + Id + " not found", Id);
            }
            throw new FetchNotFoundException("Unable to fetch, PLease try again later!", Id);
        }

        return message;
    }

    // deleting the message detail by the admin using id  \

     public boolean deleteMessageById(Long Id) throws  EntityNotFoundException{
         try {
             ContactMessage message = this.contactMessageRepository.findById(Id).orElseThrow(EntityNotFoundException::new);
             this.contactMessageRepository.delete(message);
             return true;
         } catch (Exception e) {
             return false;
         }

     }


}
