package com.example.QuizApp.service;


import com.example.QuizApp.mapper.UserMapper;
import com.example.QuizApp.model.entity.User;
import com.example.QuizApp.model.request.insert.UserInsertDTO;
import com.example.QuizApp.model.request.update.UserUpdateDTO;
import com.example.QuizApp.model.response.UserDetailResponseDTO;
import com.example.QuizApp.model.response.UserResponseDTO;
import com.example.QuizApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDetailResponseDTO getUserDetail(Long userId) {
        return userMapper.mapDetail(userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("Wrong userId")));
    }

    public List<UserResponseDTO> getUsers() {
        return userMapper.mapList(userRepository.findAll());
    }


    @Transactional
    public UserResponseDTO createUser(UserInsertDTO userInsertDTO) {
        User user = User.builder()
                .dob(userInsertDTO.getDob())
                .name(userInsertDTO.getName())
                .surname(userInsertDTO.getSurname())
                .identifier(userInsertDTO.getIdentifier())
                .password(userInsertDTO.getPassword())
                .build();
        return userMapper.map(userRepository.save(user));

    }

    @Transactional
    public void updateUser(Long userId, UserUpdateDTO userUpdateDTO) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("Wrong userId"));
        userMapper.merge(user, userUpdateDTO);
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
