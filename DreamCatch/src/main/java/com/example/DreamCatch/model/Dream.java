package com.example.DreamCatch.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Dream {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_USER")
    private User user;
    @NonNull
    private int durata;
    @NonNull
    private int energie;
    @NonNull
    private int stres;
    private String descriere;
    @NonNull
    private String tag;
    @NonNull
    private Date data;
}
