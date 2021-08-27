package ru.makhmudov.spring_boot_poll_service.service.answer_service;

import ru.makhmudov.spring_boot_poll_service.entity.Answer;

import java.util.List;

public interface AnswerService {

    List<Answer> getAllAnswers();

    void createOrUpdateAnswer(Answer answer);

    Answer getAnswer(int id);

    void deleteAnswer(int id);
}
