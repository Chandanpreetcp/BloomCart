package in.cp.BloomCartMain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cp.BloomCartMain.entities.Product;

public interface ProductRepository extends JpaRepository<Product , Long> {

}
