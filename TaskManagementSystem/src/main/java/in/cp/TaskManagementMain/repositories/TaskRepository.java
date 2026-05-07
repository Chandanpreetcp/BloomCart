package in.cp.TaskManagementMain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cp.TaskManagementMain.entities.Task;

public interface TaskRepository extends JpaRepository<Task , Integer>{

}
