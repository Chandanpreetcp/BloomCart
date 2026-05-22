package in.cp.BloomCartMain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cp.BloomCartMain.entities.Order;

public interface OrderRepository extends JpaRepository<Order , Long> {
	public List<Order> findAllByUserUserId(Long userId);
}
