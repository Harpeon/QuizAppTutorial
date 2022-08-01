package com.example.QuizApp.mapper;


import com.example.QuizApp.model.entity.User;
import com.example.QuizApp.model.request.update.UserUpdateDTO;
import com.example.QuizApp.model.response.UserDetailResponseDTO;
import com.example.QuizApp.model.response.UserResponseDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper(config = SharedConfig.class)
public interface UserMapper {
    @Named(value = "userResponseDTO")
    UserResponseDTO map(User user);

    UserDetailResponseDTO mapDetail(User user);
    
    @IterableMapping(qualifiedByName = "userResponseDTO")
    List<UserResponseDTO> mapList(List<User> user);


    void merge(@MappingTarget User user, UserUpdateDTO userUpdateDTO);

}