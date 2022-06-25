package de.hs.vs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan("de.hs.*")
@RestController
public class VsApplication {

	@GetMapping("/test")
	public String testMethod() {
		return "success";
	}

	@GetMapping("/todo")
	public ToDoItem getTodoItem() {
		ToDoItem temp = new ToDoItem();
		temp.setText("I have to do something");
		temp.setPriority(1);

		return temp;
	}

	public static void main(String[] args) {
		SpringApplication.run(VsApplication.class, args);
	}
}
