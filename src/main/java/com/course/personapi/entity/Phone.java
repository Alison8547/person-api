package com.course.personapi.entity;

import com.course.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // Pra ser uma entidade do banco de dados
@Data  // Data do lombok cria os get e set sem precisar colocar aquilo tudo
@NoArgsConstructor  // lombok construtor
@AllArgsConstructor
@Builder  // lombok adicionando várias coisas
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera um id tipo incremento 1.2.3.4.5...
    private Long id;

    @Enumerated(EnumType.STRING) // Enumerated passo o tipo q foi lá na class q eu criei
    @Column(nullable = false)  // É tipo not null
    private PhoneType phoneType;

    @Column(nullable = false, unique = true)
    private String number;
}
