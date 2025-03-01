package com.patoCode.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patoCode.todolist.entites.User;
import com.patoCode.todolist.repository.UserRepository;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;
    private User findByUser(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public Boolean save(User user){
        if(user != null){
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public Boolean delete(Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public User findById(Long id){
        User user = findByUser(id);
        return user;
    }
}
