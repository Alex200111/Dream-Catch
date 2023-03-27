package com.example.DreamCatch.service;

import com.example.DreamCatch.repository.DreamRepo;
import jakarta.persistence.Tuple;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class ChartService {

    @Autowired
    private DreamRepo dreamRepo;

    public List<Tuple> getChartList(String metrica, int idUser){
        if(metrica.equals("durata")){
            return dreamRepo.getDurataList(idUser);
        }else if(metrica.equals("energie")){
            return dreamRepo.getEnergieList(idUser);
        }else {
            return dreamRepo.getStresList(idUser);
        }
    }
}
