package in.cp.BloomCartMain.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import in.cp.BloomCartMain.entities.User;

public interface UserRepository extends JpaRepository<User , Long>{
	public User findByEmail(String email);




}
