package org.portfolio.portfoliobackend.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendMessageRequestDto {

    private String name ;

    private String email ;

    private String message ;

}
