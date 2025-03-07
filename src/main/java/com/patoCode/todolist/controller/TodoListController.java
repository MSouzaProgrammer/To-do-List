package com.patoCode.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patoCode.todolist.DTO.TodoListDTO;
import com.patoCode.todolist.entites.TodoList;
import com.patoCode.todolist.repository.TodoListRepository;
import com.patoCode.todolist.services.TodoListServices;

@RestController
@RequestMapping("/todolist")
public class TodoListController {

    @Autowired
    private TodoListServices todoListServices;
}
