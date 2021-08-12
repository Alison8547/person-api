package com.course.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception { // Criando uma class caso o usuario vá buscar um id que não existe

    public PersonNotFoundException(Long id) {
        super("Person not found with ID "+id);
    }
}
