package com.example.military.repository;

import com.example.military.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer> {
    //UserModel findByarmynumber(UserModel user);
}
