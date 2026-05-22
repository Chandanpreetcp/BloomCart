package in.cp.BloomCartMain.services;

import org.springframework.stereotype.Service;

import in.cp.BloomCartMain.entities.User;

@Service
public interface UserService {
	public User createUser(User user);
	public User getUserByEmailId(String email);
	public User loginUser(String email , String password);
	public User updateUser(String email, User updatedUser);
	public void deleteUser(Long userId);

}
