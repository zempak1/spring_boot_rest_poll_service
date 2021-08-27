package ru.makhmudov.spring_boot_poll_service.controller.poll_questions;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.makhmudov.spring_boot_poll_service.dto.api.responce.AnswerVariantDTO;
import ru.makhmudov.spring_boot_poll_service.dto.mapper.AnswerVariantMapper;
import ru.makhmudov.spring_boot_poll_service.entity.AnswerVariant;
import ru.makhmudov.spring_boot_poll_service.service.question_service.AnswerVariantsService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class AnswerVariantsController {

    private static final String DELETED = "Question with ID=%s is deleted";

    private final AnswerVariantsService answerVariantsService;

    @GetMapping("/polls/{pollId}/questions/{questionId}/answer_variants")
    public List<AnswerVariantDTO> getAnswerVariantList(
            @PathVariable int pollId, @PathVariable int questionId) {
        return answerVariantsService
                .getAnswerVariantList(pollId, questionId).stream()
                .map(AnswerVariantMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/polls/{pollId}/questions/{questionId}/answer_variants/{id}")
    public AnswerVariantDTO getAnswerVariant(
            @PathVariable int pollId, @PathVariable int questionId, @PathVariable int id) {
        return AnswerVariantMapper.INSTANCE.toDTO(
                answerVariantsService.getAnswerVariant(pollId, questionId, id));
    }

    @PostMapping("/polls/{pollId}/questions/{questionId}/answer_variants")
    public AnswerVariantDTO createAnswerVariant(
            @PathVariable int pollId,
            @PathVariable int questionId,
            @RequestBody AnswerVariant answerVariant) {
        answerVariantsService.createAnswerVariant(pollId, questionId, answerVariant);
        return AnswerVariantMapper.INSTANCE.toDTO(answerVariant);
    }

    @PutMapping("/polls/{pollId}/questions/{questionId}/answer_variants")
    public AnswerVariantDTO updateAnswerVariant(
            @PathVariable int pollId,
            @PathVariable int questionId,
            @RequestBody AnswerVariant answerVariant) {
        answerVariantsService.updateAnswerVariant(pollId, questionId, answerVariant);
        return AnswerVariantMapper.INSTANCE.toDTO(answerVariant);
    }

    @DeleteMapping("/polls/{pollId}/questions/{questionId}/answer_variants/{id}")
    public String deleteAnswerVariant(
            @PathVariable int pollId,
            @PathVariable int questionId,
            @PathVariable int id) {
        answerVariantsService.deleteAnswerVariant(pollId, questionId, id);
        return String.format(DELETED, id);
    }
}
