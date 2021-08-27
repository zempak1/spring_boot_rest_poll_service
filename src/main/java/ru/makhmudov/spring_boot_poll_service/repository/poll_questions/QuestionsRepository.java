package ru.makhmudov.spring_boot_poll_service.repository.poll_questions;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.makhmudov.spring_boot_poll_service.entity.Question;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Question, Integer> {

    List<Question> getQuestionsByPollId(int pollId);

//    Question getQuestionByPollIdAndQuestionId(int pollId, int questionId);

    Question getQuestionByIdAndPollId(int questionId, int pollId);

//    void deleteByPollIdAndQuestionId(int pollId, int questionId);

    void deleteQuestionByIdAndPollId (int questionId, int pollId);
}
