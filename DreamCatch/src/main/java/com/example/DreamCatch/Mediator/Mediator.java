package com.example.DreamCatch.Mediator;

import com.example.DreamCatch.model.Dream;
import com.example.DreamCatch.repository.DreamRepo;
import com.example.DreamCatch.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class Mediator {

    @Autowired
    private UserRepo userRepo;

    public GetUserResponse send(GetUsersQuery query) {
        GetUsersQueryHandler handler = new GetUsersQueryHandler(userRepo);
        return handler.handle(query);
    }

    public Dream send(Command command) {
        if (command instanceof AddDreamCommand) {
           return command.execute();
        } else {
            throw new RuntimeException("No handler registered for command " + command.getClass().getSimpleName());
        }
    }
}
