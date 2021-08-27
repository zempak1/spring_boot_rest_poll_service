package ru.makhmudov.spring_boot_poll_service.service.answer_service;

import ru.makhmudov.spring_boot_poll_service.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAllPersons();

    void createOrUpdatePerson(Person person);

    Person getPerson(int id);

    void deletePerson(int id);
}
