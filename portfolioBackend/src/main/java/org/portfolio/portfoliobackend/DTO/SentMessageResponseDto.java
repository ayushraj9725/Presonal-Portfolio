package org.portfolio.portfoliobackend.DTO;

import lombok.*;
import org.portfolio.portfoliobackend.Model.ContactMessage;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SentMessageResponseDto {

    private Long id ;

    private String name ;

    private String email ;

    private String message ;

    private Date sentAt;

    public static SentMessageResponseDto fromSentMessageResponseDto(ContactMessage contactMessage){
        SentMessageResponseDto responseDto = SentMessageResponseDto.builder()
                .id(contactMessage.getId())
                .name(contactMessage.getName())
                .email(contactMessage.getEmail())
                .message(contactMessage.getMessage())
                .sentAt(contactMessage.getSentAt())
                .build();

        return responseDto;
    }

}
