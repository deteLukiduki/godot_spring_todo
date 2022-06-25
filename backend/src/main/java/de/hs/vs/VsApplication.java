package de.hs.vs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
		todoItems.add(item1);

		ToDoItem item2 = new ToDoItem();
		item2.setText("Study");
		item2.setPriority(1);
		todoItems.add(item2);

		ToDoItem item3 = new ToDoItem();
		item3.setText("Wash my car");
		item3.setPriority(3);
		todoItems.add(item3);
	}

	@GetMapping("/test")
	public String testMethod() {
		return "success";
	}

	@GetMapping("/todo")
	@CrossOrigin(origins = "http://localhost:8060")
	public ToDoItem getTodoItem() {
		ToDoItem temp = new ToDoItem();
		temp.setText("I have to do something");
		temp.setPriority(1);

		return temp;
	}

	@GetMapping("/todos")
	@CrossOrigin(origins = "http://localhost:8060")
	public List<ToDoItem> getTodoItems() {
		return this.todoItems;
	}

	public static void main(String[] args) {
		SpringApplication.run(VsApplication.class, args);
	}
}
