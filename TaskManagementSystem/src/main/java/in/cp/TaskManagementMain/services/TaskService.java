package in.cp.TaskManagementMain.services;

import java.util.List;
import java.util.Optional;

import in.cp.TaskManagementMain.entities.Task;

public interface TaskService {
	public Task createTask(Task task , int userId);
	public List<Task> getAllTasks();
	public Optional<Task> getTaskByUser(int userId);
	public Task updateTasks(int userId , int id , Task task);
	public void deleteTasks(int userId , int id);

}
