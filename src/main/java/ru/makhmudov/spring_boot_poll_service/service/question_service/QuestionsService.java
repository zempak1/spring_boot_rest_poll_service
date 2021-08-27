package ru.makhmudov.spring_boot_poll_service.service.question_service;

import ru.makhmudov.spring_boot_poll_service.entity.Question;

import java.util.List;

public interface QuestionsService {

    List<Question> getQuestionList(int pollId);

    Question getQuestion(int pollId, int questionId);

    void createQuestion(int pollId, Question question);

    void updateQuestion(int pollId, Question question);

    void deleteQuestion(int pollId, int questionId);
}
