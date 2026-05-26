package in.cp.BloomCartMain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cp.BloomCartMain.entities.Product;
import in.cp.BloomCartMain.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepo;

	// create product
	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product) ;
	}

	// get all products
	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	// Get product by id
	@Override
	public Product getProductById(Long productId) {
		return productRepo.getById(productId);
	}

	// update product details
	@Override
	public Product updateProductDetails(Long id, Product updatedProduct) {
		Product existingProduct = productRepo.findById(id).orElse(null);
		existingProduct.setPrice(updatedProduct.getPrice());
		existingProduct.setCategory(updatedProduct.getCategory());
		existingProduct.setDescription(updatedProduct.getDescription());
		return productRepo.save(existingProduct);
	}

	// delete product
	@Override
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);

	}

}
