package com.example.DreamCatch.service;

import com.example.DreamCatch.model.User;
import com.example.DreamCatch.model.UserDTO;
import com.example.DreamCatch.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.logging.ErrorManager;

@AllArgsConstructor
@Service
public class IUserService implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User getUserByEmailAndPassword(String username, String password) {

        return userRepo.getUserByEmailAndPassword(username, password);
    }

    @SneakyThrows
    @Override
    public UserDTO login(UserDTO userDTO){
        User logInUser=getUserByEmailAndPassword(userDTO.getUsername(),userDTO.getPassword());

        if(logInUser == null){
            return null;
        }
        return UserDTO.builder()
                .id(logInUser.getId())
                .username(logInUser.getUsername())
                .password(logInUser.getPassword())
                .build();
    }
}
