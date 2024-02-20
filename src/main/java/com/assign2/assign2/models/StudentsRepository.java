package com.assign2.assign2.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<students, Integer>{
    List<students> findByName(String name);
    List<students> findByPid(int pid);
    
}
