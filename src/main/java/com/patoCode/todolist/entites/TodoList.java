package com.patoCode.todolist.entites;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.patoCode.todolist.enums.TodoListSector;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tdlist")
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "toDoList", cascade = CascadeType.ALL, orphanRemoval = true)
    @Autowired
    private List<Duties> lDuties;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TodoListSector todoListSector;

    @Column(nullable = false)
    private String surname;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public TodoList(){}

    public TodoList(Long id, TodoListSector todoListSector, String surname, User user) {
        this.id = id;
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

    public void insertlDuties(Duties duties) {
        this.lDuties.add(duties);
        duties.setTodoList(this);
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
        duties.setTodoList(this);
    }
}