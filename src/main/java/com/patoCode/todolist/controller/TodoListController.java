package com.patoCode.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patoCode.todolist.entites.TodoList;
import com.patoCode.todolist.services.TodoListServices;

@RestController
@RequestMapping("/todolist")
public class TodoListController {

    @Autowired
    private TodoListServices todoListServices;

    @PostMapping("/{id}")
    public ResponseEntity<String> save(@RequestBody TodoList todoList, @PathVariable Long id){
        if(todoListServices.save(todoList, id)){
            return ResponseEntity.ok("Saved!");
        }
        return ResponseEntity.notFound().build();
    }
}
