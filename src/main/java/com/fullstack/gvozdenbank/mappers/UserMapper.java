package com.fullstack.gvozdenbank.mappers;


import com.fullstack.gvozdenbank.dto.UserDTO;
import com.fullstack.gvozdenbank.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO entityToDto(UserEntity user) {
        if(user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setUser_name(user.getUser_name());
        userDTO.setUser_id(user.getUser_id());
        userDTO.setUser_type(user.getUser_type());
        return userDTO;
    }
    public UserEntity dtoToEntity(UserDTO userDTO) {
        if(userDTO == null) {
            return null;
        }

        UserEntity user = new UserEntity();
        user.setUser_name(userDTO.getUser_name());
        user.setUser_id(userDTO.getUser_id());
        user.setUser_type(userDTO.getUser_type());

        return user;
    }
}
