package com.patoCode.todolist.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patoCode.todolist.entites.Duties;
import com.patoCode.todolist.entites.TodoList;
import com.patoCode.todolist.entites.User;
import com.patoCode.todolist.enums.ProgressionStatus;
import com.patoCode.todolist.enums.Status;
import com.patoCode.todolist.repository.DutiesRepository;
import com.patoCode.todolist.repository.TodoListRepository;
import com.patoCode.todolist.repository.UserRepository;

@Service
public class DutiesServices {
    @Autowired
    private DutiesRepository dutiesRepository;
    private Duties findDutiesById(Long id){
        return dutiesRepository.findById(id).orElse(null);
    }
    
    @Autowired
    private TodoListRepository todoListRepository;
    public TodoList findByListId(Long id){
        return todoListRepository.findById(id).orElse(null);
    }

    @Autowired
    private UserRepository userRepository;
    private User findByUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    //#region save, delete[All], finbyId[All]
    public Boolean save(Long idUser, Long idList,Duties duties){
        if(findByListId(idList).getUser().getId() == idUser){
            if(duties != null){
                findByListId(idList).insertDuties(duties);
                dutiesRepository.save(duties);
                return true;
            }
        }
        return false;
    }

    public Boolean deleteById(Long id){
        if(dutiesRepository.existsById(id)){
            dutiesRepository.deleteById(id);
            return true;
        }
        return false;  
    }

    public Boolean deleteAll() {
        if(dutiesRepository.findAll() != null){
            dutiesRepository.deleteAll();
            return true;
        }
        return false;
    }

    public Duties findById(Long id){
        return findDutiesById(id);
    }

    public List<Duties> findAll(){
        return dutiesRepository.findAll();
    }
    //#endregion

    public Boolean updateProgression(Long id, ProgressionStatus progressionStatus){
            Duties duties = findDutiesById(id);
            if(duties != null){
                duties.setProgressionStatus(progressionStatus);
                dutiesRepository.save(duties);
                return true;
            }
            return false;
    }

    public ProgressionStatus getProgressionStatus(Long id){
        Duties duties = findDutiesById(id);
        if(duties != null){
            return duties.getProgressionStatus();
        }
        return null;
    }

    public Boolean updateStatus(Long id, Status status){
        Duties duties = findDutiesById(id);
        if (duties != null){
            duties.setStatus(status);
            dutiesRepository.save(duties);
            return true;
        }  
        return false;
    }

    public Status getStatus(Long id){
        Duties duties = findDutiesById(id);
        if (duties != null) {
            return duties.getStatus();
        }
        return null;
    }

    public Boolean updateDate(Long id, LocalDate date){
            Duties duties = findDutiesById(id);
            if (duties != null) {
                duties.setDueDate(date);
                dutiesRepository.save(duties);
                return true;               
            }
        return false;
    }

    public LocalDate getDate(Long id){
        Duties duties = findDutiesById(id);
        if(duties != null){
            return duties.getDueDate();
        }
        return null;
    }
}
