package com.example.DreamCatch.service;

import com.example.DreamCatch.model.User;
import com.example.DreamCatch.model.UserDTO;

public interface UserService {

    User getUserByEmailAndPassword(String email, String password);

    UserDTO login(UserDTO userDTO);

}
