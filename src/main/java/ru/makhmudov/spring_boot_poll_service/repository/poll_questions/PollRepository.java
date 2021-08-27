package ru.makhmudov.spring_boot_poll_service.repository.poll_questions;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.makhmudov.spring_boot_poll_service.entity.Poll;

public interface PollRepository extends JpaRepository<Poll, Integer> {

}
