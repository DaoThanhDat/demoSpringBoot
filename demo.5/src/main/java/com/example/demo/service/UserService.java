package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.enity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getListUser();

    Optional<User> getUserById(String id);
    UserDTO getById(String id);
    void deleteById(String id);

    void update(String id, User user);

    List<UserDTO> getByLanguage(String lang, int level);
}
