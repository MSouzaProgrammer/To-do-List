package com.patoCode.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patoCode.todolist.entites.Duties;
import com.patoCode.todolist.entites.TodoList;
import com.patoCode.todolist.enums.TodoListSector;
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

    @DeleteMapping("/{idUser}/{id}")
    public ResponseEntity<String> delete(@PathVariable long idUser, @PathVariable Long id){
        if(todoListServices.delete(id)){
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<TodoList> findAll(){
        return todoListServices.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoList> findById(@PathVariable Long id){
        return ResponseEntity.ok(todoListServices.findById(id));
    }

    @DeleteMapping("/{idTodoList}/{idDuties}")
    public ResponseEntity<String> deleteDuties(@PathVariable Long idTodoList, @PathVariable Long idDuties){
        Boolean dell = todoListServices.deleteDuties(idTodoList, idDuties);
        if(dell){
            return ResponseEntity.ok("Dutie deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Duties not ");
    }

    @DeleteMapping("/{idList}")
    public ResponseEntity<String>deleteAllDuties(@PathVariable Long idList){
        Boolean service = todoListServices.deleteAllDuties(idList);
        if (service){
            return ResponseEntity.ok("Duties deleteds!");
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/insert/{id}")
    public ResponseEntity<String>insertDuties(@PathVariable Long id,@RequestBody Duties duties){
        Boolean service = todoListServices.insertDuties(id, duties);
        if(service){
            return ResponseEntity.ok("Duties inserted!!");
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{idTodoList}")
    public ResponseEntity<String>updateSector(@RequestBody TodoListSector todoListSector, @PathVariable Long idTodoList){
        Boolean service = todoListServices.updateSector(todoListSector, idTodoList);
        if(service){
            return ResponseEntity.ok("Sector updated!");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/duties/{idList}")
    public List<Duties> getlAllDuties(@PathVariable Long idList){
        return todoListServices.getlAllDuties(idList);
    }
}