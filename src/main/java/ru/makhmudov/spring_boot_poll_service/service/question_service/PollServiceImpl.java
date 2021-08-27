package ru.makhmudov.spring_boot_poll_service.service.question_service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.makhmudov.spring_boot_poll_service.entity.Poll;
import ru.makhmudov.spring_boot_poll_service.exception.NoSuchEntityException;
import ru.makhmudov.spring_boot_poll_service.repository.poll_questions.PollRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PollServiceImpl implements PollService {

    private static final String NO_SUCH_POLL = "No such poll with ID=%s in database";

    private final PollRepository pollRepository;

    @Override
    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    @Override
    public Poll getPoll(int id) {
        throwExceptionIfEmpty(id);
        return pollRepository.getById(id);
    }

    @Override
    public Poll createPoll(Poll poll) {
        pollRepository.save(poll);
        return poll;
    }

    @Override
    public Poll updatePoll(Poll poll) {
        throwExceptionIfEmpty(poll.getId());
        pollRepository.save(poll);
        return poll;
    }

    @Override
    public void deletePoll(int id) {
        throwExceptionIfEmpty(id);
        pollRepository.deleteById(id);
    }

    private void throwExceptionIfEmpty(@PathVariable int id) {
        Poll poll = pollRepository.getById(id);
        if (poll == null) {
            throw new NoSuchEntityException(
                    String.format(NO_SUCH_POLL, id));
        }
    }
}
