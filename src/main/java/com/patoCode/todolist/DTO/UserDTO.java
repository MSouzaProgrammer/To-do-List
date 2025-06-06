package com.patoCode.todolist.DTO;

import java.util.List;

import com.patoCode.todolist.entites.TodoList;
import com.patoCode.todolist.entites.User;

public class UserDTO {
    private Long id;
    private String name;
    private List<TodoList> list;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.list = user.getTodoList();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<TodoList> getList() {
        return list;
    }
    public void setList(List<TodoList> list) {
        this.list = list;
    }

    
}
