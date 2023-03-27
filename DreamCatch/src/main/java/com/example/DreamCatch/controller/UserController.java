package com.example.DreamCatch.controller;
import com.example.DreamCatch.model.UserDTO;
import com.example.DreamCatch.service.UserService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@AllArgsConstructor
@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @SneakyThrows
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO){

        log.info("Requesting login.....");
        UserDTO user = userService.login(userDTO);
        log.info("The user is:{}", user);
        if(user == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Date gresite!");
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
