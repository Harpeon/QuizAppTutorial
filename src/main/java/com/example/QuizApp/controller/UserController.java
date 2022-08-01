package com.example.QuizApp.controller;

import com.example.QuizApp.model.request.insert.UserInsertDTO;
import com.example.QuizApp.model.request.update.UserUpdateDTO;
import com.example.QuizApp.model.response.UserDetailResponseDTO;
import com.example.QuizApp.model.response.UserResponseDTO;
import com.example.QuizApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(path = "")
    public List<UserResponseDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/{userId}")
    public UserDetailResponseDTO getUserDetail(@PathVariable("userId") Long userId) {
        return userService.getUserDetail(userId);
    }

    @PostMapping(path = "")
    public UserResponseDTO createUser(@Valid @RequestBody UserInsertDTO userInsertDTO) {
        return userService.createUser(userInsertDTO);
    }

    @PutMapping(path = "/{userId}")
    public void updateUser(@PathVariable("userId") Long userId, @RequestBody UserUpdateDTO userUpdateDTO) {
        userService.updateUser(userId, userUpdateDTO);
    }

    @DeleteMapping(path = "/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }
}
