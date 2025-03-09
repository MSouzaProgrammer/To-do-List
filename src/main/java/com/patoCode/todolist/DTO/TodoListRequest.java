package com.patoCode.todolist.DTO;

import com.patoCode.todolist.enums.TodoListSector;
import com.patoCode.todolist.entites.Duties;
import java.util.List;

public class TodoListRequest {
    private List<Duties> duties;
    private TodoListSector todoListSector;
    private String surname;

    public List<Duties> getDuties() {
        return duties;
    }

    public void setDuties(List<Duties> duties) {
        this.duties = duties;
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
}
