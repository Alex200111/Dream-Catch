package com.example.DreamCatch.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class UserDTO {
    private int id;
    private String username;
    private String password;
}
