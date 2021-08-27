package ru.makhmudov.spring_boot_poll_service.repository.poll_answers;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.makhmudov.spring_boot_poll_service.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
