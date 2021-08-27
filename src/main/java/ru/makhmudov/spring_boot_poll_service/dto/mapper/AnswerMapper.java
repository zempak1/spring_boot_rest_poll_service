package ru.makhmudov.spring_boot_poll_service.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.makhmudov.spring_boot_poll_service.dto.api.responce.AnswerDTO;
import ru.makhmudov.spring_boot_poll_service.entity.Answer;

@Mapper
public interface AnswerMapper {

    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    AnswerDTO toDTO(Answer answer);
}
