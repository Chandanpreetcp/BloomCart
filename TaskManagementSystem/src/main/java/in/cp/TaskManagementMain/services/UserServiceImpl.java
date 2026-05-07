package in.cp.TaskManagementMain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cp.TaskManagementMain.entities.User;
import in.cp.TaskManagementMain.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(int userId) {
		return userRepo.getById(userId);
	}

	@Override
	public User updateUserDetails(int userId, User user) {
		User userData = userRepo.findById(userId).orElse(null);
		if(userData != null) {
			return userRepo.save(user);
		}else {
		return null;
		}
	}

	@Override
	public void deleteUsers(int userId) {
		userRepo.deleteById(userId);
		
	}
}
