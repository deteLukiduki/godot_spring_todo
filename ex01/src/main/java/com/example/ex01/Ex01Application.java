package com.example.ex01;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Ex01Application {

	@RequestMapping("/")
	public String greeting(){
		return "hello";
	} 

	@GetMapping("/test")
	public String test(){
		return "test";
	}

	@GetMapping("/api/square/{number}")
	public String getEmployeesById(@PathVariable String number) {
		int iNumber = Integer.parseInt(number);
		return "The Squeare of " + number + " is " + iNumber * iNumber;
	}

	@GetMapping("/item")
	public Item getItem(@RequestParam(value = "index", defaultValue = "0") int index) {
		return items.get(index);
	}

	@PostMapping("/item/{name}")
	public Item addItem(@PathVariable String name) {
		Item tempItem = new Item(name);
		items.add(tempItem);
		return tempItem;
	}

	@DeleteMapping("/item")
	public Item deleteItem(@RequestParam(value = "index", defaultValue = "0") int index) {
		return items.remove(index);
	}

	
	List<Item> items = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(Ex01Application.class, args);
	}

}
