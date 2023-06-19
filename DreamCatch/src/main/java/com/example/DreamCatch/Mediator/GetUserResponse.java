package com.example.DreamCatch.Mediator;

import com.example.DreamCatch.model.User;

public class GetUserResponse {
    private final User user;

    public GetUserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
