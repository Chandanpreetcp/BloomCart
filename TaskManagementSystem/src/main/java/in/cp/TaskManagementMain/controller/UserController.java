package in.cp.TaskManagementMain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import in.cp.TaskManagementMain.entities.User;
import in.cp.TaskManagementMain.services.UserService;

@Controller
@RequestMapping("/user")

public class UserController {
	@PostMapping("/Register")
	public String registerUser(@ModelAttribute User user) {
	    userService.createUser(user);
	    return "redirect:/Login.html";
	}
	@PostMapping("/Login")
	public String loginUser(@ModelAttribute User user) {
	    // login logic
	    return "redirect:/Dashboard.html";
	}
	@Autowired
	private UserService userService;
	// Get all users
	@GetMapping
	public List<User> getAllUser(){
		return userService.getAllUsers();
	}
	
	// get users by id
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	// update users
	@PutMapping("user/{userId}")
	public User updateUserDetails(@PathVariable int userId, @RequestBody User user) {
		return userService.updateUserDetails(userId, user);
	}
	
	// delete users
	@DeleteMapping("user/{userId}")
	public void deleteUsers(@PathVariable int userId) {
		userService.deleteUsers(userId);
	}
}
