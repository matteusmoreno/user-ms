package br.com.matteusmoreno.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CreateEmailRequest {

    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;
}
