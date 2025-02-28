package com.patoCode.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.patoCode.todolist.entites.TodoList;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long>{
}
