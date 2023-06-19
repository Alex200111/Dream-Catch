package com.example.DreamCatch.Mediator;

import com.example.DreamCatch.model.Dream;
import com.example.DreamCatch.repository.DreamRepo;
import com.example.DreamCatch.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class AddDreamCommandHandler {

    @Autowired
    private final DreamRepo dreamRepo;
    @Autowired
    private final UserRepo userRepo;

    public Dream handle(AddDreamCommand command) {
        Dream dream = new Dream();
        dream.setDurata(command.getDurata());
        dream.setEnergie(command.getEnergie());
        dream.setStres(command.getStres());
        dream.setDescriere(command.getDescriere());
        dream.setTag(command.getTag());
        dream.setUser(userRepo.getById(command.getUserId()));
        dream.setData(command.getData());
        return dreamRepo.save(dream);
    }
}
