package com.patoCode.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.patoCode.todolist.entites.Duties;
import com.patoCode.todolist.entites.TodoList;
import com.patoCode.todolist.enums.Status;
import com.patoCode.todolist.enums.TodoListSector;
import com.patoCode.todolist.repository.TodoListRepository;

@Service
public class TodoListServices {
    @Autowired
    private TodoListRepository todoListRepository;

    private TodoList todoListFindById(Long id) {
        return todoListRepository.findById(id).orElse(null);
    }


    // #region save, delete[All], finbyId[All]
    public Boolean save(TodoList todoList) {
        if (todoList != null) {
            todoListRepository.save(todoList);
            return true;
        }
        return false;
    }

    public Boolean delete(Long id) {
        if (todoListRepository.existsById(id)) {
            todoListRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public TodoList findById(Long id) {
        TodoList todoList = todoListFindById(id);
        if (todoList != null) {
            return todoList;
        }
        return null;
    }

    public List<TodoList> findAll() {
        return todoListRepository.findAll();
    }
    // #endregion

    public Boolean deleteDuties(Long idTodoList, Long idDuties) {
        TodoList todoList = todoListFindById(idTodoList);
        if (todoList != null) {
            List<Duties> dutiesList = todoList.getlDuties();
            Duties dutyToRemove = dutiesList.stream().filter(d -> d.getId().equals(idDuties)).findFirst().orElse(null);
            if (dutyToRemove == null) {
                return false;
            }
            dutiesList.remove(dutyToRemove);
            todoListRepository.save(todoList);
            return true;
        }
        return false;
    }

    public Boolean deleteAllDuties(Long id) {
        TodoList todoList = todoListFindById(id);
        if (todoList != null) {
            List<Duties> dutiesList = todoList.getlDuties();
            for (Duties duties : dutiesList) {
                dutiesList.remove(duties);
            }
            todoListRepository.save(todoList);
            return true;
        }
        return false;
    }

    public Boolean insertDuties(Long id, Duties duties){
        TodoList todoList = todoListFindById(id);
        if(todoList != null){
            todoList.insertDuties(duties);
            return true;
        }
        return false;
    }

    public Boolean updateSector(TodoListSector todoListSector, Long idTodoList){
        TodoList todoList = todoListFindById(idTodoList);
        if(todoList != null){
            todoList.setTodoListSector(todoListSector);
            return true;
        }
        return false;
    }

    public List<Duties> getlAllDuties(Long idList){
        TodoList todoList = todoListFindById(idList);
        return todoList.getlDuties();
    }

    public Duties getDuties(Long idList, Long idDuties){
        Duties dutie;

        TodoList todoList = todoListFindById(idList);
        if (todoList == null) {
            return null;
        }
        List<Duties> duties = todoList.getlDuties();
        return dutie = duties.stream().filter(d -> d.getId().equals(idDuties)).findFirst().orElse(null);
    }


}
