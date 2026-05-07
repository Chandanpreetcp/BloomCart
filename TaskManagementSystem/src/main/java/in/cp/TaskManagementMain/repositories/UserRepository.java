package in.cp.TaskManagementMain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cp.TaskManagementMain.entities.User;

public interface UserRepository extends JpaRepository<User , Integer> {

}
