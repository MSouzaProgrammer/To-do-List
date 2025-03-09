package com.patoCode.todolist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patoCode.todolist.entites.TodoList;
import com.patoCode.todolist.entites.User;
import com.patoCode.todolist.repository.UserRepository;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoListServices todoListServices;

    private User findByUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // #region CRUD FINALIZED
    public Boolean save(User user) {
        if (user != null) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public Boolean delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public User findById(Long id) {
        return findByUser(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    // #endregion

    public List<TodoList> getList(Long id) {
        User user = findByUser(id);
        return user.getTodoList();
    }

    public Boolean addTodoList(TodoList todoList, Long id) {
        User user = findByUser(id);
        user.addList(todoList);
        return true;
    }
}