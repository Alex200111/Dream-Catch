package com.example.DreamCatch.service;

import com.example.DreamCatch.model.Dream;
import com.example.DreamCatch.model.DreamDTO;

public interface DreamService {

    public Dream saveDream(DreamDTO dreamDTO);
}
