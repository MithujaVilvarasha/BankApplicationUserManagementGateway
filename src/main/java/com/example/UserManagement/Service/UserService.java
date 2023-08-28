package com.example.UserManagement.Service;

import com.example.UserManagement.Model.User;
import com.example.UserManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<User> register(User user) {

        try{
            User user1=userRepository.save(user);

            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<User> update(Long id, User user) {

        Optional<User> user1=userRepository.findById(id);

        if(user1.isPresent()){
            user1.get().setUsername(user.getUsername());
            user1.get().setPassword(user.getPassword());

            userRepository.save(user1.get());
            return new ResponseEntity<>(user1.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
