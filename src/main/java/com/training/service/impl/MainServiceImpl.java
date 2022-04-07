package com.training.service.impl;

import com.training.model.User;
import com.training.repository.MainRepository;
import com.training.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
public class MainServiceImpl implements MainService {

    private final MainRepository mainRepository;

    public MainServiceImpl(MainRepository mainRepository) {

        this.mainRepository = mainRepository;
    }

    public User saveOrUpdate(User user){
        log.info("MainService: save user - " + user);
        mainRepository.save(user);
        return user;
    }

    public void delete(Integer id){
        log.info("MainService: delete user by id -" + id);
        mainRepository.deleteById(id);
    }

    public User getUserById(Integer id){
        log.info("MainService: get user by id - " + id);

        return mainRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("MainService: user with id - " + id + "do not exist");
                    return new EntityNotFoundException("user with id - " + id + "do not exist");
                });
    }

    public List<User> getAllUsers(){
        log.info("MainService: get all users");
        return mainRepository.findAll();
    }

}
