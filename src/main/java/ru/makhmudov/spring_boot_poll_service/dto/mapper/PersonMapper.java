package ru.makhmudov.spring_boot_poll_service.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.makhmudov.spring_boot_poll_service.dto.api.responce.PersonDTO;
import ru.makhmudov.spring_boot_poll_service.entity.Person;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "email", source = "user.username")
    @Mapping(target = "answers", ignore = true)
    PersonDTO toDTO(Person person);
}
