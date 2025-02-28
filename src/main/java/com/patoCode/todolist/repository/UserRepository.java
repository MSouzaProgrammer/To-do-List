package com.patoCode.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.patoCode.todolist.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
