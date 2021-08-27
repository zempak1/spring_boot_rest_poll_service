package ru.makhmudov.spring_boot_poll_service.service.question_service;

import ru.makhmudov.spring_boot_poll_service.entity.Poll;

import java.util.List;

public interface PollService {

    List<Poll> getAllPolls();

    Poll createPoll(Poll poll);

    Poll updatePoll(Poll poll);

    Poll getPoll(int id);

    void deletePoll(int id);
}
