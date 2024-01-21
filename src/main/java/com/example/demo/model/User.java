package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	String name;
	String city;
	

    // Add other user-related fields as needed, such as password, roles, etc.

    // Constructors, getters, and setters

    // Default constructor required by JPA
    public User() {
    }

    public User(String name, String city) {
        this.name = name;
        this.city = city;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    // toString, equals, and hashCode methods (optional but recommended for entities)
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

	
}
