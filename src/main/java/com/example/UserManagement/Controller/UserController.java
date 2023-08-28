package com.example.UserManagement.Controller;

import com.example.UserManagement.Model.User;
import com.example.UserManagement.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user){
        return userService.register(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable Long id,@RequestBody @Valid User user){
        return userService.update(id,user);
    }
}
