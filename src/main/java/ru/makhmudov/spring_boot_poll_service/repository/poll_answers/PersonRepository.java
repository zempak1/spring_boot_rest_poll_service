package ru.makhmudov.spring_boot_poll_service.repository.poll_answers;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.makhmudov.spring_boot_poll_service.entity.Person;


public interface PersonRepository extends JpaRepository<Person, Integer> {

}
