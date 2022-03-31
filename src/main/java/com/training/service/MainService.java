package com.training.service;

import com.training.model.User;
import com.training.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    @Autowired
    private final MainRepository mainRepository;

    public MainService(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public void saveOrUpdate(User user){
        mainRepository.save(user);
    }

    public void delete(Integer id){
        mainRepository.deleteById(id);
    }

    public User getUserById(Integer id){
        return mainRepository.getUserById(id);
    }

}
