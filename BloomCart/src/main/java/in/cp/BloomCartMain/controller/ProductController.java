package in.cp.BloomCartMain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cp.BloomCartMain.entities.Product;
import in.cp.BloomCartMain.services.ProductService;

@RestController
@RequestMapping("/Product")
@CrossOrigin(origins = "*")
public class ProductController {
	@Autowired
	private ProductService productService;

	// create product
	@PostMapping("/add")
	public Product createProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	// get all products
	@GetMapping("/all")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}

	// get product by id
	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable Long productId) {
		return productService.getProductById(productId);
	}

	//update product details
	@PutMapping("/update/{productId}")
	public Product updateProductDetails(@PathVariable Long productId, @RequestBody Product updatedProduct) {
		return productService.updateProductDetails(productId, updatedProduct);
	}

	// delete product
	@DeleteMapping("/delete/{productId}")
	public void deleteProduct(@PathVariable Long productId) {
		productService.deleteProduct(productId);
	}

}
