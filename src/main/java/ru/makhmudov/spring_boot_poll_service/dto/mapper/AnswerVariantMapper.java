package ru.makhmudov.spring_boot_poll_service.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.makhmudov.spring_boot_poll_service.dto.api.responce.AnswerVariantDTO;
import ru.makhmudov.spring_boot_poll_service.entity.AnswerVariant;

@Mapper
public interface AnswerVariantMapper {

    AnswerVariantMapper INSTANCE = Mappers.getMapper(AnswerVariantMapper.class);

    AnswerVariantDTO toDTO(AnswerVariant answerVariant);
}
