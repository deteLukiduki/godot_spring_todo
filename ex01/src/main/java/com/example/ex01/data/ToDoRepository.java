package com.example.ex01.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoItem, String> {
    ToDoItem findByName(String name);
}
