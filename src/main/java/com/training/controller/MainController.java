package com.training.controller;

import com.training.model.User;
import com.training.service.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/user")
    public User read(@RequestParam(name = "id") Integer id){
        return mainService.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return mainService.getAllUsers();
    }

    @GetMapping("/delete/user")
    public void delete(@RequestParam Integer id){
        mainService.delete(id);
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        return mainService.saveOrUpdate(user);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user){
        return mainService.saveOrUpdate(user);
    }
}
