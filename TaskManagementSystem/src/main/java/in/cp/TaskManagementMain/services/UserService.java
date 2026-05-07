package in.cp.TaskManagementMain.services;

import java.util.List;

import in.cp.TaskManagementMain.entities.User;

public interface UserService {
	public User createUser(User user);
	public List<User> getAllUsers();
	public User getUserById(int userId);
	public User updateUserDetails(int userId , User user);
	public void deleteUsers(int userId);
}
