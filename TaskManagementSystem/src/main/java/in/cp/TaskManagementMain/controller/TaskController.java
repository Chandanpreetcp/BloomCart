package in.cp.TaskManagementMain.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.cp.TaskManagementMain.entities.Task;
import in.cp.TaskManagementMain.services.TaskService;

@RestController
@RequestMapping("/task")

public class TaskController {
	@Autowired
	private TaskService taskService;
	
	// create tasks
	@PostMapping("/{userId}")
	public Task createTask(@RequestBody Task task , @PathVariable int userId) {
		return taskService.createTask(task, userId);	
	}
	
	// get all tasks
	@GetMapping
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
	}
	
	// get tasks by users
	@GetMapping("/user")
	public Optional<Task> getTaskByUser(@RequestParam int userId){
		return taskService.getTaskByUser(userId);
	}
	
	// update tasks
	@PutMapping("/{userId}/{id}")
	public Task updateTasks(@PathVariable int userId, @PathVariable int id , @RequestBody Task task) {
		return taskService.updateTasks(userId, id , task);
	}
	
	// delete tasks
	public void deleteTasks(@PathVariable int userId,@PathVariable int id) {
	}
	
}
