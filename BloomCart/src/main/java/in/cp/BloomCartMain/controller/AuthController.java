package in.cp.BloomCartMain.controller;

import in.cp.BloomCartMain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cp.BloomCartMain.repositories.UserRepository;
import in.cp.BloomCartMain.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/signup")
	public String signup(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		return "User Registered Successfully";
	}
	
	@PostMapping("/login") 
	public  String login(@RequestBody User user) {
		authenticationManager.authenticate(
				new
				UsernamePasswordAuthenticationToken(
						((in.cp.BloomCartMain.entities.User) user).getEmail(),
						user.getPassword()
						)
				);
		String token = jwtUtil.generateToken(user.getEmail());
		return token;
	}
}
