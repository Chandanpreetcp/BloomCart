package in.cp.BloomCartMain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cp.BloomCartMain.entities.User;
import in.cp.BloomCartMain.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepo;

	// create users
	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	// login users
	@Override
	public User loginUser(String email, String password) {
		 User user = userRepo.findByEmail(email);
		 if(user != null && user.getPassword().equals(password)) {
		        return user;
		    }
		    return null;
	}

	// Update user details
	@Override
	public User updateUser(String email, User updatedUser) {
		 User existingUser = userRepo.findByEmail(email);

	        existingUser.setName(updatedUser.getName());
	        existingUser.setEmail(updatedUser.getEmail());
	        existingUser.setPassword(updatedUser.getPassword());
	        return userRepo.save(existingUser);
	}

	// get users by email id
	@Override
	public User getUserByEmailId(String email) {
			return userRepo.findByEmail(email);
	}

	// delete user
	@Override
	public void deleteUser(Long userId) {
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent()) {
	        User deleteduser = user.get();
	        userRepo.delete(deleteduser);
	    }else {
	    	throw new RuntimeException("User not found");
	    }
		
	}

	

}
