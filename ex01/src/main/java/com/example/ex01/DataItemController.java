package com.example.ex01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
public class DataItemController {
    
    @Autowired
    ItemRepository itemRepository;

    // public DemoItem createDemoItem() {
    //     itemRepository.save(empty);
    // }
}
