package com.example.DreamCatch.service;

import com.example.DreamCatch.Mediator.AddDreamCommand;
import com.example.DreamCatch.Mediator.Mediator;
import com.example.DreamCatch.model.Dream;
import com.example.DreamCatch.model.DreamDTO;
import com.example.DreamCatch.model.User;
import com.example.DreamCatch.repository.DreamRepo;
import com.example.DreamCatch.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class IDreamService implements DreamService{

    @Autowired
    private Mediator mediator;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private DreamRepo dreamRepo;

    @Override
    public Dream saveDream(DreamDTO dreamDTO){
        AddDreamCommand command = new AddDreamCommand(dreamDTO.getDurata(), dreamDTO.getEnergie(), dreamDTO.getStres(),
                dreamDTO.getDescriere(), dreamDTO.getTag(), dreamDTO.getIdUser(),
                dreamDTO.getData(),userRepo,dreamRepo);
        return mediator.send(command);

    }
}
