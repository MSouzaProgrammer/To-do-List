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

import com.patoCode.todolist.DTO.UserDTO;
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
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error in some component of your body");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Boolean deleted = userServices.delete(id);
        if (deleted) {
            return ResponseEntity.ok("Deleted!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not finded!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        User user = userServices.findById(id);
        if (user != null) {
            return ResponseEntity.ok(new UserDTO(user));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<User> findAll() {
        List<User> users = userServices.findAll();
        return users;
    }

    @GetMapping("/allList/{id}")
    public List<TodoList> getAllList(@PathVariable Long id) {
        List<TodoList> todoList = userServices.getAllList(id);
        return todoList;
    }

    @GetMapping("/list/{idUser}/{idList}")
    public TodoList getList(@PathVariable Long idUser, @PathVariable Long idList){
        return userServices.getList(idUser, idList);
    }
}