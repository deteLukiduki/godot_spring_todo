package de.hs.vs;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EntityScan("de.hs.*")
@RestController
public class VsApplication {
	List<ToDoItem> todoItems = new ArrayList<>();

	public VsApplication() {
		ToDoItem item1 = new ToDoItem();
		item1.setText("Play games");
		item1.setPriority(1);
		item1.setID(todoItems.size());
		todoItems.add(item1);

		ToDoItem item2 = new ToDoItem();
		item2.setText("Study");
		item2.setPriority(1);
		item2.setID(todoItems.size());
		todoItems.add(item2);

		ToDoItem item3 = new ToDoItem();
		item3.setText("Wash my car");
		item3.setPriority(3);
		item3.setID(todoItems.size());
		todoItems.add(item3);
	}

	@GetMapping("/test")
	public String testMethod() {
		return "success";
	}

	@GetMapping("/todo")
	@CrossOrigin(origins = {"http://localhost:8060", "http://localhost:8080"})
	public ToDoItem getTodoItem() {
		ToDoItem temp = new ToDoItem();
		temp.setText("I have to do something");
		temp.setPriority(1);

		return temp;
	}

	@GetMapping("/todos")
	@CrossOrigin(origins = {"http://localhost:8060", "http://localhost:8080"})
	public List<ToDoItem> getTodoItems() {
		System.out.println("get");
		return this.todoItems;
	}

	@PostMapping(path="/todos", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = {"http://localhost:8060", "http://localhost:8080"})
	public ToDoItem addTodoItem(@RequestBody ToDoItem todo) {
		System.out.println("post");
		ToDoItem tempTodo = new ToDoItem();
		tempTodo.setText(todo.getText());
		tempTodo.setPriority(todo.getPriority());
		tempTodo.setID(this.todoItems.size());
		todoItems.add(tempTodo);
		return tempTodo;
	}

	@DeleteMapping(path="/todos/{id}")
	@CrossOrigin(origins = {"http://localhost:8060", "http://localhost:8080"})
	public void deleteTodoItem(@PathVariable int id) {
		System.out.println("Delete");
		todoItems.remove(id);

		int idCounter = 0;
		for(ToDoItem item : todoItems) {
			item.setID(idCounter);
			idCounter++;
		}
		
	}

	public static void main(String[] args) {
		SpringApplication.run(VsApplication.class, args);
	}
}
