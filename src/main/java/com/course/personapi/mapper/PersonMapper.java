package com.course.personapi.mapper;

import com.course.personapi.dto.request.PersonDTO;
import com.course.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class); // Criando uma instancia

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy") // pegando e formatando a data
    Person toModel(PersonDTO personDTO); // Person para person DTO

    PersonDTO toDTO(Person person);

}
