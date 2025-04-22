package com.patoCode.todolist.controller;

import java.time.LocalDate;
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
import com.patoCode.todolist.enums.ProgressionStatus;
import com.patoCode.todolist.enums.Status;
import com.patoCode.todolist.services.DutiesServices;

@RestController
@RequestMapping("/duties")
public class DutiesController {
    @Autowired
    private DutiesServices dutiesServices;

    @PostMapping("/{idUser}/{idList}")
    public ResponseEntity<String> save(@PathVariable Long idUser, @PathVariable Long idList, @RequestBody Duties duties){
        Boolean saved = dutiesServices.save(idUser, idList, duties);
        if (saved){
            return ResponseEntity.ok("Sucess!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        Boolean service = dutiesServices.deleteById(id);
        if(service){
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll(){
        Boolean service = dutiesServices.deleteAll();
        if(service){
            return ResponseEntity.ok("Deleted!");
        }
        return null;
    }

    @GetMapping("find/{id}")
    public Duties findById(@PathVariable Long id){
        return dutiesServices.findById(id);
    }

    @GetMapping
    public List<Duties> findAll(){
        return dutiesServices.findAll();
    }

    @PutMapping("/update/id")
    public ResponseEntity<String> updateProgression(@PathVariable Long id, @RequestBody ProgressionStatus progressionStatus){
        Boolean service = dutiesServices.updateProgression(id, progressionStatus);
        if(service) return ResponseEntity.ok("Updated");
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/progress/{id}")
    public ProgressionStatus getProgressionStatus(@PathVariable long id){
        return dutiesServices.getProgressionStatus(id);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable Long id, @RequestBody Status status){
        Boolean service = dutiesServices.updateStatus(id, status); 
        if(service){
            return ResponseEntity.ok("Status updated!");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/status/{id}")
    public Status getStatus(@PathVariable long id){
        return dutiesServices.getStatus(null);
    }

    @PutMapping("/date/{id}")
    public ResponseEntity<String> updateDate(@PathVariable Long id,@RequestBody LocalDate date){
        Boolean service = dutiesServices.updateDate(id, date);
        if(service){
            return ResponseEntity.ok("Date updated!");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/date/{id}")
    public LocalDate getDate(@PathVariable Long id){
        return dutiesServices.getDate(id);
    }
}