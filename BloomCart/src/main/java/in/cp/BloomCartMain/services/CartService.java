package in.cp.BloomCartMain.services;

import java.util.List;

import in.cp.BloomCartMain.entities.Cart;

public interface CartService {
	public Cart addToCart(Cart cart);
	public List<Cart> getAllCartItems(Long userId);
	public Cart getOneCartItem(Long cartId);
    public Cart updateCart(Long cartId, Cart updatedCart);
    public void deleteCart(Long cartId);
    

}
