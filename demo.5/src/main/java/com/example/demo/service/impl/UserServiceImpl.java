package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.enity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserDTO> getListUser() {
        List<User> users = userRepository.findAll();
        return userMapper.toListDTO(users);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDTO getById(String id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(String id, User user) {
      userRepository.update(id,user);

    }

    @Override
    public List<UserDTO> getByLanguage(String lang, int level) {
        List<User> users = userRepository.findByLanguage(lang,level);
        return userMapper.toListDTO(users);
    }
}
