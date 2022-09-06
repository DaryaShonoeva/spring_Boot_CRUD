package com.example.spring_Boot_CRUD.repository;

import com.example.spring_Boot_CRUD.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
