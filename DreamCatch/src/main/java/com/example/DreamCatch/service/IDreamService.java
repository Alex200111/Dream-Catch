package com.example.DreamCatch.service;

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
    private DreamRepo dreamRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Dream saveDream(DreamDTO dreamDTO){
        Dream dream=new Dream();
        dream.setDurata(dreamDTO.getDurata());
        dream.setEnergie(dreamDTO.getEnergie());
        dream.setStres(dreamDTO.getStres());
        dream.setDescriere(dreamDTO.getDescriere());
        dream.setTag(dreamDTO.getTag());
        dream.setUser(userRepo.getById(dreamDTO.getIdUser()));
        dream.setData(dreamDTO.getData());

        return dreamRepo.save(dream);
    }
}
