package ru.makhmudov.spring_boot_poll_service.controller.poll_answers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.makhmudov.spring_boot_poll_service.dto.api.responce.PersonDTO;
import ru.makhmudov.spring_boot_poll_service.dto.mapper.PersonMapper;
import ru.makhmudov.spring_boot_poll_service.entity.Person;
import ru.makhmudov.spring_boot_poll_service.exception.FieldValidationException;
import ru.makhmudov.spring_boot_poll_service.exception.NoSuchEntityException;
import ru.makhmudov.spring_boot_poll_service.service.answer_service.PersonService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class PersonController {

    private static final String NO_SUCH_PERSON = "No such person with ID=%s in database";
    private static final String DELETED = "Person with ID=%s is deleted";

    private final PersonService personService;

    @GetMapping("/persons")
    public List<PersonDTO> getPersonList() {
        return personService.getAllPersons().stream()
                .map(PersonMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/persons/{id}")
    public PersonDTO getPerson(@PathVariable int id) {
        throwExceptionIfEmpty(id);
        Person person = personService.getPerson(id);
        return PersonMapper.INSTANCE.toDTO(person);
    }

    @PostMapping("/persons")
    public PersonDTO createPerson(@Valid @RequestBody Person person, BindingResult br) {
        br.getAllErrors().forEach(System.out::println);
        throwExceptionIfValidationFails(br);
        personService.createOrUpdatePerson(person);
        return PersonMapper.INSTANCE.toDTO(person);
    }

    @PutMapping("/persons")
    public PersonDTO updatePerson(@Valid @RequestBody Person person, BindingResult br) {
        throwExceptionIfValidationFails(br);
        personService.createOrUpdatePerson(person);
        return PersonMapper.INSTANCE.toDTO(person);
    }

    @DeleteMapping("/persons/{id}")
    public String deletePerson(@PathVariable int id) {
        throwExceptionIfEmpty(id);
        personService.deletePerson(id);
        return String.format(DELETED, id);
    }

    private void throwExceptionIfEmpty(@PathVariable int id) {
        Person person = personService.getPerson(id);
        if (person == null) {
            throw new NoSuchEntityException(
                    String.format(NO_SUCH_PERSON, id));
        }
    }

    private void throwExceptionIfValidationFails(BindingResult br) {
        if (br.hasErrors()) {
            throw new FieldValidationException(br.getAllErrors().toString());
        }
    }
}
