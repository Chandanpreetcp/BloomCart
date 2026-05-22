package in.cp.BloomCartMain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cp.BloomCartMain.entities.User;
import in.cp.BloomCartMain.services.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired 
	private UserService userService;
	// create user
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);	
	}
	
	// login user
	@PostMapping("/login")
		public ResponseEntity<?> loginUser(@RequestBody User loginUser) {

		    User user = userService.loginUser(
		            loginUser.getEmail(),
		            loginUser.getPassword()
		    );

		    if(user != null) {
		        return ResponseEntity.ok(user);
		    }
		    else {
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Email or Password");
		    }
		}
	
	// update user details
	@PutMapping("/update/{email}")
	public User updateUser(@PathVariable String email, @RequestBody User updatedUser) {
		return userService.updateUser(email, updatedUser);
	}
	
	// get user by email id
	@GetMapping("/getByEmail/{email}")
	public User getUserByEmailId(@PathVariable String email) {
		return userService.getUserByEmailId(email);
	}
	
	// delete user
	@DeleteMapping("delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
	    userService.deleteUser(userId);
	    return ResponseEntity.ok("User Deleted Successfully");
	}
	
}
