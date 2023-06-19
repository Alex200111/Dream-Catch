package com.example.DreamCatch.service;

import com.example.DreamCatch.repository.DreamRepo;
import jakarta.persistence.Tuple;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class ChartService {

    @Autowired
    private DreamRepo dreamRepo;

    public List<Tuple> getChartList(Date inceput, Date sfarsit, String metrica, int idUser){
        if(metrica.equals("durata")){
            return dreamRepo.getDurataList(idUser,inceput,sfarsit);
        }else if(metrica.equals("energie")){
            return dreamRepo.getEnergieList(idUser,inceput,sfarsit);
        }else {
            return dreamRepo.getStresList(idUser,inceput,sfarsit);
        }
    }
}
