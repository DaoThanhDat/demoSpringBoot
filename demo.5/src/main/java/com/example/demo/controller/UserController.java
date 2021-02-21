package com.example.demo.controller;


import com.example.demo.dto.UserDTO;
import com.example.demo.enity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService userService;


    @PostMapping("/user")
    public ResponseEntity<?> create(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll() {
        List<UserDTO> users = userService.getListUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        Optional<User> users = userService.getUserById(id);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/gett/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") String id) {
        UserDTO user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUserById(@RequestParam(name = "language") String lang,
                                         @RequestParam(name = "level") int level) {
        List<UserDTO> users = userService.getByLanguage(lang,level);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        userService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") String id, @RequestBody User user) {
        userService.update(id, user);
    }
}
