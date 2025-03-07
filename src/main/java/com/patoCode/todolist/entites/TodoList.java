package com.patoCode.todolist.entites;

import java.util.List;
import java.util.Optional;

import com.patoCode.todolist.enums.TodoListSector;
import com.patoCode.todolist.repository.UserRepository;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_TDList")
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "toDoList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Duties> lDuties;

    @Enumerated(EnumType.STRING)
    private TodoListSector todoListSector;
    private String surname;

    @ManyToOne
    private User user;

    public TodoList(){}
    public TodoList(Long id, List<Duties> lDuties, TodoListSector todoListSector, String surname, User user) {
        this.id = id;
        this.lDuties = lDuties;
        this.todoListSector = todoListSector;
        this.surname = surname;
        this.user = user;
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

    public void insertDuties(Duties duties){
        lDuties.add(duties);
    }
}