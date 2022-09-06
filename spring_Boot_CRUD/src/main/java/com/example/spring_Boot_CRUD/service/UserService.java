package com.example.spring_Boot_CRUD.service;

import com.example.spring_Boot_CRUD.models.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    void removeUser(Long id);

    User getUserById(Long id);

    List<User> listUser();

}
