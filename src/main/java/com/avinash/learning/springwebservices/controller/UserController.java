package com.avinash.learning.springwebservices.controller;

import com.avinash.learning.springwebservices.DTO.Users;
import com.avinash.learning.springwebservices.bean.WelcomeBean;
import com.avinash.learning.springwebservices.exception.UserNotFoundException;
import com.avinash.learning.springwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(path="/users")
    public List<Users> getUsers(){
        return userService.findAll();
    }


    @GetMapping(path="/users/{age}")
    public Users findOneUser(@PathVariable String age) {
        Users user= userService.findOne(age);
        if (user ==null ){
            throw new UserNotFoundException("{age}-"+age);
        }
        return user;
    }

    @DeleteMapping("/users/{age}")
    public ResponseEntity<Object> deleteUser(@PathVariable String age) {
        Users user= userService.deletebyId(age);
        if (user ==null ){
            throw new UserNotFoundException("{age}-"+age);
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{age}")
                .buildAndExpand(user.getAge()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/users")
    public String save(@RequestBody Users user){
        Users users = userService.save(user);
        return "User Saved is ---> " + users.toString();
    }

    @PostMapping("/bestuser")
    public ResponseEntity<Object> savePost(@RequestBody Users user){
        Users users = userService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{age}").
                buildAndExpand(users.getAge()).toUri();
        return ResponseEntity.created(location).build();

    }

}
