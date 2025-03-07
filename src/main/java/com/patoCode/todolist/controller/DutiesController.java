package com.patoCode.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patoCode.todolist.entites.Duties;
import com.patoCode.todolist.services.DutiesServices;

@RestController
public class DutiesController {
    @Autowired
    private DutiesServices dutiesServices;

    public ResponseEntity<String> save(@RequestBody Duties duties){
        Boolean saved = dutiesServices.save(duties);
        if (saved){
            return ResponseEntity.ok("Sucess!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
    }
}
