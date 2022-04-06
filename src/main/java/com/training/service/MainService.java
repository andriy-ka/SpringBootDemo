package com.training.service;

import com.training.model.User;
import com.training.repository.MainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    private final MainRepository mainRepository;

    public MainService(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public User saveOrUpdate(User user){
        mainRepository.save(user);
        return user;
    }

    public void delete(Integer id){
        mainRepository.deleteById(id);
    }

    public User getUserById(Integer id){
        return mainRepository.getUserById(id);
    }

    public List<User> getAllUsers(){
        return mainRepository.findAll();
    }

}
