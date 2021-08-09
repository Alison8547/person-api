package com.course.personapi.repository;

import com.course.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {  // Criando um repository passando a class Person, e o id Long

}
