package com.example.DreamCatch.repository;

import com.example.DreamCatch.model.Dream;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DreamRepo extends JpaRepository<Dream,Integer> {

    @Query("SELECT d.durata, d.data  FROM Dream d WHERE d.user.id = :idUser ")
    List<Tuple> getDurataList(@Param("idUser") int idUser);

    @Query("SELECT d.stres, d.data  FROM Dream d WHERE d.user.id = :idUser ")
    List<Tuple> getStresList(@Param("idUser") int idUser);

    @Query("SELECT d.energie, d.data  FROM Dream d WHERE d.user.id = :idUser ")
    List<Tuple> getEnergieList(@Param("idUser") int idUser);
}
