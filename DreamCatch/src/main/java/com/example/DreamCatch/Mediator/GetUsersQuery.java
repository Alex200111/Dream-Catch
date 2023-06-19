package com.example.DreamCatch.Mediator;

public class GetUsersQuery {
    private final String username;
    private final String password;

    public GetUsersQuery(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
