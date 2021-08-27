package ru.makhmudov.spring_boot_poll_service.service.question_service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.makhmudov.spring_boot_poll_service.entity.Poll;
import ru.makhmudov.spring_boot_poll_service.entity.Question;
import ru.makhmudov.spring_boot_poll_service.exception.NoSuchEntityException;
import ru.makhmudov.spring_boot_poll_service.repository.poll_questions.PollRepository;
import ru.makhmudov.spring_boot_poll_service.repository.poll_questions.QuestionsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionsServiceImpl implements QuestionsService {

    private static final String NO_SUCH_POLL = "No such poll with ID=%s in database";
    private static final String NO_SUCH_QUESTION = "No such question with ID=%s in database";

    private final PollRepository pollRepository;
    private final QuestionsRepository questionsRepository;

    @Override
    public List<Question> getQuestionList(int pollId) {
        throwExceptionIfPollEmpty(pollId);
        return questionsRepository.getQuestionsByPollId(pollId);
    }

    @Override
    public Question getQuestion(int pollId, int questionId) {
        throwExceptionIfPollEmpty(pollId);
        throwExceptionIfQuestionEmpty(pollId, questionId);
        return questionsRepository.getQuestionByIdAndPollId(questionId, pollId);
    }

    @Override
    public void createQuestion(int pollId, Question question) {
        throwExceptionIfPollEmpty(pollId);
        question.setPoll(pollRepository.getById(pollId));
        questionsRepository.save(question);
    }

    @Override
    public void updateQuestion(int pollId, Question question) {
        throwExceptionIfPollEmpty(pollId);
        throwExceptionIfQuestionEmpty(pollId, question.getId());
        question.setPoll(pollRepository.getById(pollId));
        questionsRepository.save(question);
    }

    @Override
    public void deleteQuestion(int pollId, int questionId) {
        throwExceptionIfPollEmpty(pollId);
        throwExceptionIfQuestionEmpty(pollId, questionId);
        questionsRepository.deleteQuestionByIdAndPollId(questionId, pollId);
    }

    private void throwExceptionIfPollEmpty(int pollId) {
        Poll poll = pollRepository.getById(pollId);
        if (poll == null) {
            throw new NoSuchEntityException(
                    String.format(NO_SUCH_POLL, pollId));
        }
    }

    private void throwExceptionIfQuestionEmpty(int pollId, int questionId) {
        Question question = questionsRepository.getQuestionByIdAndPollId(questionId, pollId);
        if (question == null) {
            throw new NoSuchEntityException(
                    String.format(NO_SUCH_QUESTION, questionId));
        }
    }
}
