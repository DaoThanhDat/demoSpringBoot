package com.example.demo.repository;

import com.example.demo.dto.UserDTO;
import com.example.demo.enity.User;
import com.mongodb.client.result.UpdateResult;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> customMethod();
    UserDTO getUserById(String id);
    void update(String id,User user);

    List<User> findByLanguage(String lang, int level);
}
