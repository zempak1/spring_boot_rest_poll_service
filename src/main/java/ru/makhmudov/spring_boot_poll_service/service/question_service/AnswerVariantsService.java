package ru.makhmudov.spring_boot_poll_service.service.question_service;

import ru.makhmudov.spring_boot_poll_service.entity.AnswerVariant;

import java.util.List;

public interface AnswerVariantsService {

    List<AnswerVariant> getAnswerVariantList(int pollId, int questionId);

    AnswerVariant getAnswerVariant(int pollId, int questionId, int id);

    void createAnswerVariant(int pollId, int questionId, AnswerVariant answerVariant);

    void updateAnswerVariant(int pollId, int questionId, AnswerVariant answerVariant);

    void deleteAnswerVariant(int pollId, int questionId, int id);
}
