package com.training.repository;

import com.training.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainRepository extends CrudRepository<User, Integer> {
        User getUserById(Integer id);
        List<User> findAll();
}
