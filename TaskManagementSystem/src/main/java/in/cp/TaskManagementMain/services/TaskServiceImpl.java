package in.cp.TaskManagementMain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cp.TaskManagementMain.entities.Task;
import in.cp.TaskManagementMain.repositories.TaskRepository;
import in.cp.TaskManagementMain.repositories.UserRepository;
import in.cp.TaskManagementMain.entities.User;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepo;
	@Autowired
	private UserRepository userRepo;
	@Override
	public Task createTask(Task task , int userId) {
		User user = userRepo.findById(userId).orElse(null);
		task.setUser(user);
		return taskRepo.save(task) ;
	}
	@Override
	public List<Task> getAllTasks() {
		return taskRepo.findAll();
	}
	@Override
	public Optional<Task> getTaskByUser(int userId) {
		return taskRepo.findById(userId);
	}
	@Override
	public Task updateTasks(int userId, int id ,  Task task) {
		Task taskData = taskRepo.findById(userId).orElse(null);
		if(taskData != null) {
		return taskRepo.save(task);
	}else {
		return null;
	}
	}
	@Override
	public void deleteTasks(int userId, int id) {
		
	}
}
