package com.example.demo.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5501/")
@RestController
@RequestMapping("/users")
public class UserController {
	

private static final Logger log = LoggerFactory.getLogger(UserController.class);
 
	private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    


    // Create a new user
   
    
    
//    @PostMapping("/createuser")
//    public ResponseEntity<String> createUser(@RequestBody User users) {
//        try {
//            User savedUser = userRepository.save(users);
//            log.info("User inserted successfully: {}", savedUser);
//            return ResponseEntity.ok("User inserted successfully with ID: " + savedUser.getId());
//        } catch (Exception e) {
//            log.error("Error inserting user: {}", e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting user");
//        }
//    }
    
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            User savedUser = userRepository.save(user);
            log.info("User inserted successfully: {}", savedUser);
            return ResponseEntity.ok("User inserted successfully with ID: " + savedUser.getId());
        } catch (DataIntegrityViolationException e) {
            log.error("Error inserting user due to data integrity violation: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error inserting user: Duplicate entry");
        } catch (Exception e) {
            log.error("Error inserting user: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting user");
        }
    }

    
    
    
 // Get all users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by ID
    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userRepository.findById(id);
    }

    // Update a user
    @PutMapping("/update/{userId}")
    public User updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(updatedUser.getName());
                    user.setCity(updatedUser.getCity());
                    // Update other fields as needed
                    return userRepository.save(user);
                })
                .orElse(null); // Handle the case where the user with the given ID is not found
    }

    // Delete a user by ID
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }
	
}
