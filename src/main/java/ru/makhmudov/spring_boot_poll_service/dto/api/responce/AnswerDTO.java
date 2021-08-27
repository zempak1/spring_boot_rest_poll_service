package ru.makhmudov.spring_boot_poll_service.dto.api.responce;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import ru.makhmudov.spring_boot_poll_service.entity.AnswerVariant;
import ru.makhmudov.spring_boot_poll_service.entity.Person;
import ru.makhmudov.spring_boot_poll_service.entity.Poll;
import ru.makhmudov.spring_boot_poll_service.entity.Question;

import java.util.List;

@Data
public class AnswerDTO {

    int id;
    Person person;
    Poll poll;
    Question question;
    List<AnswerVariant> answerVariantList;

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "id=" + id +
                ", person=" + person +
                ", poll=" + poll +
                ", question=" + question +
                ", answerVariantList=" + answerVariantList +
                '}';
    }
}
