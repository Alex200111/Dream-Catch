package com.example.DreamCatch.repository;

import com.example.DreamCatch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

    @Query("SELECT us FROM User us WHERE us.username= :username and us.password= :password ")
    User getUserByEmailAndPassword(String username, String password);
}
