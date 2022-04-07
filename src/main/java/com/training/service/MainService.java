package com.training.service;

import com.training.model.User;

import java.util.List;

public interface MainService {

    User saveOrUpdate(User user);
    void delete(Integer id);
    User getUserById(Integer id);
    List<User> getAllUsers();
}
