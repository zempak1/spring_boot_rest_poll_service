package ru.makhmudov.spring_boot_poll_service.dto.api.responce;

import lombok.Data;

import java.util.List;

@Data
public class PersonDTO {

    int id;
    String email;
    List<AnswerDTO> answers;
}
