package com.example.test.converters;

import com.example.test.dto.UserDto;
import com.example.test.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface UserDtoToUserConverter extends Converter<UserDto, User> {
    @Mapping(target = "email")
    @Mapping(target = "name")
    @Mapping(target = "image")
    User convert(final UserDto source);
}
