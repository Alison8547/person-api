package com.course.personapi.controller;


import com.course.personapi.dto.MessageResponseDTO;
import com.course.personapi.entity.Person;
import com.course.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;  // criando a refêrencia

    @Autowired
    public PersonController(PersonRepository personRepository) { // Construtor com a anotação Autowired
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person) { // Metodo post para criar
        Person savedPerson = personRepository.save(person); // Salvando no repository
        return MessageResponseDTO // A mensagem string q criei lá na outra class
                .builder()
                .message("Created person with ID " + savedPerson.getId())   // pegando o id q salvou
                .build();
    }
}
