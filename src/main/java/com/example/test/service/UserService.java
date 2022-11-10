package com.example.test.service;

import com.example.test.dto.UserStatusDto;
import com.example.test.entities.User;
import com.example.test.entities.enums.Status;
import com.example.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(final User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new BadRequestException("Пользователь с таким email уже зарегистрирован");
        }
        return userRepository.save(user);
    }

    public User get(final long id) {
        return userRepository.findUserById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User %d is not found.", id)));
    }

    public UserStatusDto update(final long id, final Status status) {
        User user = get(id);
        Status oldStatus = user.getStatus();
        user.setStatus(status);
        userRepository.save(user);
        return new UserStatusDto(user.getId(), user.getStatus(), oldStatus);

    }
}
