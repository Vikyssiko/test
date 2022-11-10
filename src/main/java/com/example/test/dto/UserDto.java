package com.example.test.dto;

import com.example.test.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @Email
    private String email;

    private String image;
}
