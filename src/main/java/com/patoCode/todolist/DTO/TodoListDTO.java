package com.patoCode.todolist.DTO;

import java.util.List;

import com.patoCode.todolist.entites.Duties;
import com.patoCode.todolist.entites.TodoList;
import com.patoCode.todolist.entites.User;
import com.patoCode.todolist.enums.TodoListSector;

public class TodoListDTO {

    private Long id;
    private List<Duties> lDuties;
    private TodoListSector todoListSector;
    private String surname;
    private User user;
    public TodoListDTO(TodoList todoList) {
        this.id = todoList.getId();
        this.lDuties = todoList.getlDuties();
        this.todoListSector = todoList.getTodoListSector();
        this.surname = todoList.getSurname();
        this.user = todoList.getUser();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Duties> getlDuties() {
        return lDuties;
    }
    public void setlDuties(List<Duties> lDuties) {
        this.lDuties = lDuties;
    }
    public TodoListSector getTodoListSector() {
        return todoListSector;
    }
    public void setTodoListSector(TodoListSector todoListSector) {
        this.todoListSector = todoListSector;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}