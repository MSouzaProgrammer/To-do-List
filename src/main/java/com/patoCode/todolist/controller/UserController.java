package com.patoCode.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patoCode.todolist.DTO.TodoListRequest;
import com.patoCode.todolist.entites.TodoList;
import com.patoCode.todolist.entites.User;
import com.patoCode.todolist.repository.UserRepository;
import com.patoCode.todolist.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody User user) {
        Boolean saved = userServices.save(user);
        if (saved) {
            return ResponseEntity.ok("Sucess!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Boolean deleted = userServices.delete(id);
        if (deleted) {
            return ResponseEntity.ok("Deleted!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userServices.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<User> findAll() {
        List<User> users = userServices.findAll();
        return users;
    }

    @GetMapping("/list/{id}")
    public List<TodoList> geList(@PathVariable Long id) {
        List<TodoList> todoList = userServices.getList(id);
        return todoList;
    }
}