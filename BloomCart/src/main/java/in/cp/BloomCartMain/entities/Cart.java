package in.cp.BloomCartMain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Cart {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cartId;
	@JoinColumn
	@ManyToOne
    private User user;
	@JoinColumn
    @ManyToOne
    private Product product;
	@Column
    private int quantity;

	public Long getCartId() {
		return cartId;
	}
	public void setId(Long cartId) {
		this.cartId = cartId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
