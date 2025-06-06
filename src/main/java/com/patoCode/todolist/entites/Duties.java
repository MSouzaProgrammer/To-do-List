package com.patoCode.todolist.entites;

import java.time.LocalDate;
import com.patoCode.todolist.enums.ProgressionStatus;
import com.patoCode.todolist.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_duties")
public class Duties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idUser;

    @Column(nullable = false)
    private String duties;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProgressionStatus progressionStatus;

    @Column(nullable = false)
    private LocalDate dueDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "todo_list_id")
    private TodoList toDoList;

    public Duties(){}

    public Duties(Long id,String duties, Status status, ProgressionStatus progressionStatus, TodoList toDoList, LocalDate dueDate) {
        this.id = id;
        this.duties = duties;
        this.status = status;
        this.progressionStatus = progressionStatus;
        this.dueDate = dueDate;
        this.toDoList = toDoList;
    }

    public Long getId() {
        return id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ProgressionStatus getProgressionStatus() {
        return progressionStatus;
    }

    public void setProgressionStatus(ProgressionStatus progressionStatus) {
        this.progressionStatus = progressionStatus;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TodoList getTodoList() {
        return toDoList;
    }

    public void setTodoList(TodoList todoList) {
        this.toDoList = todoList;
    }
}