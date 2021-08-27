package ru.makhmudov.spring_boot_poll_service.controller.poll_answers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ru.makhmudov.spring_boot_poll_service.dto.api.responce.AnswerDTO;
import ru.makhmudov.spring_boot_poll_service.dto.mapper.AnswerMapper;
import ru.makhmudov.spring_boot_poll_service.entity.Answer;
import ru.makhmudov.spring_boot_poll_service.exception.FieldValidationException;
import ru.makhmudov.spring_boot_poll_service.exception.NoSuchEntityException;
import ru.makhmudov.spring_boot_poll_service.service.answer_service.AnswerService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class AnswerController {

    private static final String NO_SUCH_VARIANT = "No such answer  with ID=%s in database";
    private static final String DELETED = "Answer  with ID=%s is deleted";

    private final AnswerService answerService;

    @GetMapping("/answers")
    public List<AnswerDTO> getAnswerList() {

        List<AnswerDTO> answerDTOS = answerService.getAllAnswers().stream().map(AnswerMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());

        for (AnswerDTO answerDTO: answerDTOS) {
            System.out.println(answerDTO);
        }

        return answerDTOS;
    }

    @GetMapping("/answers/{id}")
    public AnswerDTO getAnswer(@PathVariable int id) {
        throwExceptionIfEmpty(id);
        Answer answer = answerService.getAnswer(id);
        return AnswerMapper.INSTANCE.toDTO(answer);
    }

    @PostMapping("/answers")
    public AnswerDTO createAnswer(
            @Valid @RequestBody Answer answer, BindingResult br) {
        br.getAllErrors().forEach(System.out::println);
        throwExceptionIfValidationFails(br);
        answerService.createOrUpdateAnswer(answer);
        return AnswerMapper.INSTANCE.toDTO(answer);
    }

    @PutMapping("/answers")
    public AnswerDTO updateAnswer(
            @Valid @RequestBody Answer answer, BindingResult br) {
        throwExceptionIfEmpty(answer.getId());
        throwExceptionIfValidationFails(br);
        answerService.createOrUpdateAnswer(answer);
        return AnswerMapper.INSTANCE.toDTO(answer);
    }

    @DeleteMapping("/answers/{id}")
    public String deleteAnswer(@PathVariable int id) {
        throwExceptionIfEmpty(id);
        answerService.deleteAnswer(id);
        return String.format(DELETED, id);
    }

    private void throwExceptionIfEmpty(@PathVariable int id) {
        Answer answer = answerService.getAnswer(id);
        if (answer == null) {
            throw new NoSuchEntityException(
                    String.format(NO_SUCH_VARIANT, id));
        }
    }

    private void throwExceptionIfValidationFails(BindingResult br) {
        if (br.hasErrors()) {
            throw new FieldValidationException(br.getAllErrors().toString());
        }
    }
}
