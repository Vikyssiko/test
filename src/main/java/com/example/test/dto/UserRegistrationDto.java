package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {

    @NotNull
    @NotBlank
    private Long id;
}
