package com.course.personapi.service;

import com.course.personapi.dto.response.MessageResponseDTO;
import com.course.personapi.dto.request.PersonDTO;
import com.course.personapi.entity.Person;
import com.course.personapi.exception.PersonNotFoundException;
import com.course.personapi.mapper.PersonMapper;
import com.course.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service // anotação para dizer para o Spring q essa class vai ter as regras de negócios
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return getMessageResponseDTO(savedPerson.getId(), "Created person with ID ");
    }

    public List<PersonDTO> listAll() { // Metodo post
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);

    }

    public void deleteById(Long id) throws PersonNotFoundException {
        verifyIfExists(id);// Passando o metodo aq e verificando se existe o id

        personRepository.deleteById(id);
    }


    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);

        Person update = personRepository.save(personToUpdate);
        return getMessageResponseDTO(update.getId(), "Update person with ID ");
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException { // Criando esse metodo porque antes tava duplicando linhas
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO getMessageResponseDTO(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
