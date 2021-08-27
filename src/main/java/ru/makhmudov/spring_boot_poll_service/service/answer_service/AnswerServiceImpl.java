package ru.makhmudov.spring_boot_poll_service.service.answer_service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.makhmudov.spring_boot_poll_service.entity.Answer;
import ru.makhmudov.spring_boot_poll_service.repository.poll_answers.AnswerRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public void createOrUpdateAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public Answer getAnswer(int id) {
        return answerRepository.getById(id);
    }

    @Override
    public void deleteAnswer(int id) {
        answerRepository.deleteById(id);
    }
}
