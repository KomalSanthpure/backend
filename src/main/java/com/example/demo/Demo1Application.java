package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Demo1Application {
	
	@RequestMapping(value="/")
	public String indexO() {
		return "hello";
	}
	 // Handling GET requests
	
    @GetMapping("/get-example")
    public String handleGetRequest() {
        return "This is a GET request example";
    }

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
