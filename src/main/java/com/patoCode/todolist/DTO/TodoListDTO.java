package com.patoCode.todolist.DTO;

import com.patoCode.todolist.enums.TodoListSector;

public class TodoListDTO {
    private String surname;
    private TodoListSector todoListSector;
    private Long id;
    
    public TodoListDTO() {}
    public TodoListDTO(String surname, TodoListSector todoListSector, Long id) {
        this.surname = surname;
        this.todoListSector = todoListSector;
        this.id = id;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public TodoListSector getTodoListSector() {
        return todoListSector;
    }
    public void setTodoListSector(TodoListSector todoListSector) {
        this.todoListSector = todoListSector;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    
}
