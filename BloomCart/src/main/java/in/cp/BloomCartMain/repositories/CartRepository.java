package in.cp.BloomCartMain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cp.BloomCartMain.entities.Cart;

public interface CartRepository extends JpaRepository< Cart ,Long> {
	List<Cart> findByUserUserId(Long userId);
}
