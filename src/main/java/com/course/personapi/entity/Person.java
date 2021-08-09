package com.course.personapi.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity // Pra ser uma entidade do banco de dados
@Data   // Data do lombok cria os get e set sem precisar colocar aquilo tudo
@NoArgsConstructor // lombok construtor
@AllArgsConstructor
@Builder // lombok também adicionando várias coisas
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera um id tipo incremento 1.2.3.4.5...
    private Long id;

    @Column(nullable = false)   // É tipo not null
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true) // unique = true: só pode criar com um cpf único
    private String cpf;


    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}) // OneToMany ou Um para muitos. Tá fazendo um relacionamento com minha class phone, FetchType.LAZY performance. ,cascade é tipo já cadastra logo tudo na hora do q passou lá
    private List<Phone> phones = new ArrayList<>();
}
