package com.example.test.controller;

import com.example.test.dto.StatusDto;
import com.example.test.dto.UserDto;
import com.example.test.dto.UserRegistrationDto;
import com.example.test.dto.UserStatusDto;
import com.example.test.entities.User;
import com.example.test.entities.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;
import com.example.test.service.UserService;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final ConversionService conversionService;

    @PostMapping("/upload")
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
                                                 @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                File image = new File("/home/vikyssiko/Downloads/" + name);
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(image));
                stream.write(bytes);
                stream.close();
                return image.getAbsolutePath();
            } catch (Exception e) {
                return "Вам не удалось загрузить " + name + " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить " + name + " потому что файл пустой.";
        }
    }

    @PostMapping
    public UserRegistrationDto post(@Valid @RequestBody final UserDto userDto) {
        final User user = conversionService.convert(userDto, User.class);
        final User createdUser = userService.create(user);
        return conversionService.convert(createdUser, UserRegistrationDto.class);
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable final long id) {
        return conversionService.convert(userService.get(id), UserDto.class);
    }

    @PatchMapping("/{id}")
    public UserStatusDto changeStatus(@PathVariable final long id,
                                      @RequestBody final StatusDto status) {
        return userService.update(id, Status.valueOf(status.getStatus().name()));
    }
}
