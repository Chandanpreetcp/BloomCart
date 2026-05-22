package in.cp.BloomCartMain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Product {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productId;
	@Column
	private String description;
	@Column
	private double price;
	@Column
	private String imageURL;
	@Column
	private String category;
	public Long getProductId() {
		return productId;
	}
	public void setId(Long productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}
