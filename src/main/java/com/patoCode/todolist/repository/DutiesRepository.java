package com.patoCode.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.patoCode.todolist.entites.Duties;

@Repository
public interface DutiesRepository extends JpaRepository<Duties, Long>{    
}
