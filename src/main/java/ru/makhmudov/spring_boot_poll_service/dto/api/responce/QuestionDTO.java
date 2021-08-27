package ru.makhmudov.spring_boot_poll_service.dto.api.responce;

import lombok.Data;
import ru.makhmudov.spring_boot_poll_service.enums.QuestionType;

@Data
public class QuestionDTO {

    int id;
    int pollId;
    QuestionType questionType;
    String name;
}
