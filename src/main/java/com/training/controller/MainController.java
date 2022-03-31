package com.training.controller;

import com.training.model.User;
import com.training.service.MainService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping("/create")
    public void create(@RequestBody User user){
        System.out.println(user);
        mainService.saveOrUpdate(user);
    }

    @PostMapping("/update")
    public void update(@RequestBody User user){
        mainService.saveOrUpdate(user);
    }

    @GetMapping("/user")
    public User read(@RequestParam Integer id){
        return mainService.getUserById(id);
    }

    @GetMapping("/delete/user")
    public void delete(@RequestParam Integer id){
        mainService.delete(id);
    }

}
