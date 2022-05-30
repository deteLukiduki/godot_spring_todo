package com.example.ex01.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ToDoItem {
    @Id
    private String todo;

    int priority;

    public String getTodo() {
        return this.todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}