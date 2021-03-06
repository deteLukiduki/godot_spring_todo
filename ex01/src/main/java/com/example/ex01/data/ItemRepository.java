package com.example.ex01.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<DemoItem, String>{
    DemoItem findByName(String name);
}
