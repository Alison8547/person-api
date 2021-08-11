package com.course.personapi.dto.request;

import com.course.personapi.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO { // class dto para validações


    private Long id;

    @NotEmpty   // não pode ser vazio
    @Size(min = 2, max = 100)  // tamanho minimo 2 e maximo 100
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    @NotEmpty
    @CPF  // validação de cpf
    private String cpf;


    private String birthDate;

    @NotEmpty
    @Valid  // Validação de todas outras coisas da lista
    private List<Phone> phones = new ArrayList<>();
}
