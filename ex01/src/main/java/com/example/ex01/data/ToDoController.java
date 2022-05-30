package com.example.ex01.data;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    @Autowired
    ToDoRepository toDoRepository;

    @GetMapping(produces = "application/json")
    List<ToDoItem> getToDoList() {
        return toDoRepository.findAll();
    }
}