package com.training.controller;

import com.training.model.User;
import com.training.service.impl.MainServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/main")
@RestController
@Slf4j
public class MainController {

    private final MainServiceImpl mainService;

    public MainController(MainServiceImpl mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/user")
    public User read(@RequestParam(name = "id") Integer id){
        log.info("MainController: get user by id - " + id);
        return mainService.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        log.info("MainController: get all users");
        return mainService.getAllUsers();
    }

    @GetMapping("/delete/user")
    public void delete(@RequestParam Integer id){
        log.info("MainController: delete user by id - " + id);
        mainService.delete(id);
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        log.info("MainController: create user - " + user);
        return mainService.saveOrUpdate(user);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user){
        log.info("MainController: update user - " + user);
        return mainService.saveOrUpdate(user);
    }
}
