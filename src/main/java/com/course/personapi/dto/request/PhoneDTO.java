package com.course.personapi.dto.request;

import com.course.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhoneDTO {


    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;
}
