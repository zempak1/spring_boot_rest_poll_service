package ru.makhmudov.spring_boot_poll_service.service.question_service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.makhmudov.spring_boot_poll_service.entity.AnswerVariant;
import ru.makhmudov.spring_boot_poll_service.entity.Poll;
import ru.makhmudov.spring_boot_poll_service.entity.Question;
import ru.makhmudov.spring_boot_poll_service.exception.NoSuchEntityException;
import ru.makhmudov.spring_boot_poll_service.repository.poll_questions.AnswerVariantsRepository;
import ru.makhmudov.spring_boot_poll_service.repository.poll_questions.PollRepository;
import ru.makhmudov.spring_boot_poll_service.repository.poll_questions.QuestionsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AnswerVariantsServiceImpl
        implements AnswerVariantsService {

    private static final String NO_SUCH_POLL = "No such poll with ID=%s in database";
    private static final String NO_SUCH_QUESTION = "No such question with ID=%s in database";
    private static final String NO_SUCH_VARIANT = "No such answer variant with ID=%s in database";

    private final PollRepository pollRepository;
    private final QuestionsRepository questionsRepository;
    private final AnswerVariantsRepository answerVariantRepository;

    @Override
    public List<AnswerVariant> getAnswerVariantList(int pollId, int questionId) {
        throwExceptionIfPollEmpty(pollId);
        throwExceptionIfQuestionEmpty(pollId, questionId);
        return answerVariantRepository.getAnswerVariantsByQuestionPollIdAndQuestionId(pollId, questionId);
    }

    @Override
    public AnswerVariant getAnswerVariant(int pollId, int questionId, int id) {
        throwExceptionIfPollEmpty(pollId);
        throwExceptionIfQuestionEmpty(pollId, questionId);
        throwExceptionIfAnswerVariantEmpty(pollId, questionId, id);
        return answerVariantRepository
                .getAnswerVariantsByQuestionPollIdAndQuestionIdAndId(pollId, questionId, id);
    }

    @Override
    public void createAnswerVariant(int pollId, int questionId, AnswerVariant answerVariant) {
        throwExceptionIfPollEmpty(pollId);
        throwExceptionIfQuestionEmpty(pollId, questionId);
        answerVariant.setQuestion(questionsRepository.getQuestionByIdAndPollId(questionId, pollId));
        answerVariantRepository.save(answerVariant);
    }

    @Override
    public void updateAnswerVariant(int pollId, int questionId, AnswerVariant answerVariant) {
        throwExceptionIfPollEmpty(pollId);
        throwExceptionIfQuestionEmpty(pollId, questionId);
        throwExceptionIfAnswerVariantEmpty(pollId, questionId, answerVariant.getId());
        answerVariant.setQuestion(questionsRepository.getQuestionByIdAndPollId(questionId, pollId));
        answerVariantRepository.save(answerVariant);
    }

    @Override
    public void deleteAnswerVariant(int pollId, int questionId, int id) {
        throwExceptionIfPollEmpty(pollId);
        throwExceptionIfQuestionEmpty(pollId, questionId);
        throwExceptionIfAnswerVariantEmpty(pollId, questionId, id);
        answerVariantRepository.deleteByQuestionIdAndAndId(questionId, id);
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

    private void throwExceptionIfAnswerVariantEmpty(int pollId, int questionId, int id) {
        AnswerVariant answerVariant = answerVariantRepository
                .getAnswerVariantsByQuestionPollIdAndQuestionIdAndId(pollId, questionId, id);
        if (answerVariant == null) {
            throw new NoSuchEntityException(
                    String.format(NO_SUCH_VARIANT, id));
        }
    }
}
