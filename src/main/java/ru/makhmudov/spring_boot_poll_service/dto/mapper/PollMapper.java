package ru.makhmudov.spring_boot_poll_service.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.makhmudov.spring_boot_poll_service.dto.api.responce.PollDTO;
import ru.makhmudov.spring_boot_poll_service.entity.Poll;

@Mapper
public interface PollMapper {

    PollMapper INSTANCE = Mappers.getMapper(PollMapper.class);

    PollDTO toDTO(Poll poll);
}
