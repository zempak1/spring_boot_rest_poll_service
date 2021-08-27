package ru.makhmudov.spring_boot_poll_service.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.makhmudov.spring_boot_poll_service.dto.api.responce.QuestionDTO;
import ru.makhmudov.spring_boot_poll_service.entity.Question;

@Mapper
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Mapping(target = "pollId", source = "poll.id")
    QuestionDTO toDTO(Question question);
}
