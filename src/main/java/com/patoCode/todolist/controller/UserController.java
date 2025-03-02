package com.patoCode.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.patoCode.todolist.entites.User;
import com.patoCode.todolist.services.UserServices;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;
    
    @PostMapping
    public ResponseEntity<String> save(@RequestBody User user){
        Boolean saved = userServices.save(user);
        if (saved) {
            return ResponseEntity.ok("Sucess!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed!");
    }
}
