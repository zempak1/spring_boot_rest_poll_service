package ru.makhmudov.spring_boot_poll_service.controller.poll_questions;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.makhmudov.spring_boot_poll_service.dto.api.responce.PollDTO;
import ru.makhmudov.spring_boot_poll_service.dto.mapper.PollMapper;
import ru.makhmudov.spring_boot_poll_service.entity.Poll;
import ru.makhmudov.spring_boot_poll_service.service.question_service.PollService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class PollController {

    private static final String DELETED = "Poll with ID=%s is deleted";

    private final PollService pollService;

    @GetMapping("/polls")
    public List<PollDTO> getPollList() {
        return pollService.getAllPolls().stream()
                .map(PollMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/polls/{id}")
    public PollDTO getPoll(@PathVariable int id) {
        return PollMapper.INSTANCE.toDTO(
                pollService.getPoll(id));
    }

    @PostMapping("/polls")
    public PollDTO createPoll(@RequestBody Poll poll) {
        pollService.createPoll(poll);
        return PollMapper.INSTANCE.toDTO(poll);
    }

    @PutMapping("/polls")
    public PollDTO updatePoll(@RequestBody Poll poll) {
        pollService.updatePoll(poll);
        return PollMapper.INSTANCE.toDTO(poll);
    }

    @DeleteMapping("/polls/{id}")
    public String deletePoll(@PathVariable int id) {
        pollService.deletePoll(id);
        return String.format(DELETED, id);
    }
}
