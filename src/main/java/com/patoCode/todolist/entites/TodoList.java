package com.patoCode.todolist.entites;

import java.util.List;

import com.patoCode.todolist.enums.DutieSector;

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
    private DutieSector dutieSector;
    private String surname;

    public TodoList(){}
    public TodoList(Long id, List<Duties> lDuties, DutieSector dutieSector, String surname) {
        this.id = id;
        this.lDuties = lDuties;
        this.dutieSector = dutieSector;
        this.surname = surname;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public DutieSector getDutieSector() {
        return dutieSector;
    }
    public void setDutieSector(DutieSector dutieSector) {
        this.dutieSector = dutieSector;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
}