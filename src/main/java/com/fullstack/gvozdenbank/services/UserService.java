package com.fullstack.gvozdenbank.services;

import com.fullstack.gvozdenbank.dto.UserDTO;
import com.fullstack.gvozdenbank.entities.UserEntity;
import com.fullstack.gvozdenbank.mappers.UserMapper;
import com.fullstack.gvozdenbank.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public String createUser(UserDTO user) {
        UserEntity userEntity = userMapper.dtoToEntity(user);
        userRepository.save(userEntity);
        return "New user created !";
    }

    public UserDTO getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        return userMapper.entityToDto(userEntity);
    }

    public ArrayList<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        ArrayList<UserDTO> usersDTOS = new ArrayList<>();
        for(UserEntity user : users) {
            usersDTOS.add(userMapper.entityToDto(user));
        }
        return usersDTOS;
    }

    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "Successfully deleted user " + id;
    }
}
