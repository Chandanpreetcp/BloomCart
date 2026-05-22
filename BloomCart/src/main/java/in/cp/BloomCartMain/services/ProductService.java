package in.cp.BloomCartMain.services;

import java.util.List;

import in.cp.BloomCartMain.entities.Product;

public interface ProductService {
	public Product addProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProductById(Long ProductId);
	public Product updateProductDetails(Long productId , Product updatedProduct);
	public void deleteProduct(Long productId);

}
