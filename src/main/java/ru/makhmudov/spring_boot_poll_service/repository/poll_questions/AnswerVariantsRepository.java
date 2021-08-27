package ru.makhmudov.spring_boot_poll_service.repository.poll_questions;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.makhmudov.spring_boot_poll_service.entity.AnswerVariant;

import java.util.List;

public interface AnswerVariantsRepository extends JpaRepository<AnswerVariant, Integer> {


    List<AnswerVariant> getAnswerVariantsByQuestionPollIdAndQuestionId(int pollId, int questionId);

    AnswerVariant getAnswerVariantsByQuestionPollIdAndQuestionIdAndId (int pollId, int questionId, int id);

    void deleteByQuestionIdAndAndId(int questionId, int id);
}
