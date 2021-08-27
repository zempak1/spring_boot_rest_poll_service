package ru.makhmudov.spring_boot_poll_service.dto.api.responce;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PollDTO {

    Integer id;
    String name;
    String description;
    LocalDate startDate;
    LocalDate endDate;
}
