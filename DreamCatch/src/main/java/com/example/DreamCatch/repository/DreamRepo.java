package com.example.DreamCatch.repository;

import com.example.DreamCatch.model.Dream;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DreamRepo extends JpaRepository<Dream,Integer> {

    @Query("SELECT d.durata, d.data  FROM Dream d WHERE d.user.id = :idUser AND d.data BETWEEN :inceput AND :sfarsit")
    List<Tuple> getDurataList(@Param("idUser")int idUser, @Param("inceput")Date inceput,@Param("sfarsit") Date sfarsit);

    @Query("SELECT d.stres, d.data  FROM Dream d WHERE d.user.id = :idUser AND d.data BETWEEN :inceput AND :sfarsit")
    List<Tuple> getStresList(@Param("idUser")int idUser, @Param("inceput")Date inceput,@Param("sfarsit") Date sfarsit);

    @Query("SELECT d.energie, d.data  FROM Dream d WHERE d.user.id = :idUser AND d.data BETWEEN :inceput AND :sfarsit")
    List<Tuple> getEnergieList(@Param("idUser")int idUser, @Param("inceput")Date inceput,@Param("sfarsit") Date sfarsit);
}
