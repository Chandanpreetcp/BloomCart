package in.cp.BloomCartMain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cp.BloomCartMain.entities.Cart;
import in.cp.BloomCartMain.entities.Product;
import in.cp.BloomCartMain.entities.User;
import in.cp.BloomCartMain.repositories.CartRepository;
import in.cp.BloomCartMain.repositories.ProductRepository;
import in.cp.BloomCartMain.repositories.UserRepository;

@Service
public class CartServiceImpl implements CartService {
	@Autowired 
	private CartRepository cartRepo;
	@Autowired 
	private ProductRepository productRepo;
	@Autowired 
	private UserRepository userRepo;

	// add items to cart
	@Override
	public Cart addToCart(Cart cart) {
		Long userId = cart.getUser().getUserId();
	    Long productId = cart.getProduct().getProductId();

	    User user = userRepo.findById(userId).orElse(null);

	    Product product = productRepo.findById(productId).orElse(null);

	    cart.setUser(user);
	    cart.setProduct(product);

	    return cartRepo.save(cart);
	}

	// get all cart items of user
	@Override
	public List<Cart> getAllCartItems(Long userId) {
		return cartRepo.findByUserUserId(userId);
	}

	 // Update cart item
	@Override
   public  Cart updateCart(Long cartId, Cart updatedCart) {
	   Cart existingCart = cartRepo.getById(cartId);
	   existingCart.setQuantity(updatedCart.getQuantity());
		existingCart.setProduct(updatedCart.getProduct());
		existingCart.setUser(updatedCart.getUser());
		return cartRepo.save(existingCart);
    }

   // delete Cart
   @Override
   public void deleteCart(Long cartId) {
	cartRepo.deleteById(cartId);
   }

   // get specific cart item
   @Override
   public Cart getOneCartItem(Long cartId) {
	return cartRepo.getById(cartId);
   }
}
