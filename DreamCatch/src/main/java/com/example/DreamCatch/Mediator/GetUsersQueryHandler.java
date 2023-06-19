package com.example.DreamCatch.Mediator;

import com.example.DreamCatch.model.User;
import com.example.DreamCatch.repository.UserRepo;

public class GetUsersQueryHandler {
    private final UserRepo userRepository;

    public GetUsersQueryHandler(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public GetUserResponse handle(GetUsersQuery query) {
        User user = userRepository.getUserByEmailAndPassword(query.getUsername(), query.getPassword());
        return new GetUserResponse(user);
    }
}
