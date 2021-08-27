package ru.makhmudov.spring_boot_poll_service.service.answer_service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.makhmudov.spring_boot_poll_service.entity.Person;
import ru.makhmudov.spring_boot_poll_service.repository.poll_answers.PersonRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public void createOrUpdatePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person getPerson(int id) {
        return personRepository.getById(id);
    }

    @Override
    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }
}
