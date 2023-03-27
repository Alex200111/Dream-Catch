package com.example.DreamCatch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DreamDTO {

    private int durata;
    private int energie;
    private int stres;
    private int idUser;
    private String descriere;
    private String tag;
    private String data;
}
