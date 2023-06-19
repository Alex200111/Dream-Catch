package com.example.DreamCatch.Mediator;

import com.example.DreamCatch.model.Dream;
import com.example.DreamCatch.repository.DreamRepo;
import com.example.DreamCatch.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@AllArgsConstructor
public class AddDreamCommand implements Command{

    private final int durata;
    private final int energie;
    private final int stres;
    private final String descriere;
    private final String tag;
    private final int userId;
    private final Date data;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DreamRepo dreamRepo;

    public int getDurata() {
        return durata;
    }

    public int getEnergie() {
        return energie;
    }

    public int getStres() {
        return stres;
    }

    public String getDescriere() {
        return descriere;
    }

    public String getTag() {
        return tag;
    }

    public int getUserId() {
        return userId;
    }

    public Date getData() {
        return data;
    }

    @Override
    public Dream execute() {
        AddDreamCommandHandler addDreamCommandHandler=new AddDreamCommandHandler(dreamRepo,userRepo);
        return addDreamCommandHandler.handle(this);
    }
}
