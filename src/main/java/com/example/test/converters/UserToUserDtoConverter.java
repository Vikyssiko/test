package com.example.test.converters;

import com.example.test.dto.UserDto;
import com.example.test.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

import javax.validation.constraints.NotNull;

@Mapper(componentModel = "spring")
public interface UserToUserDtoConverter extends Converter<User, UserDto> {
    @Mapping(target = "email")
    @Mapping(target = "name")
    @Mapping(target = "image")
    UserDto convert(@NotNull final User source);
}
