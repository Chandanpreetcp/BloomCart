package in.cp.BloomCartMain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cp.BloomCartMain.entities.Cart;
import in.cp.BloomCartMain.services.CartService;

@RestController
@RequestMapping("/Cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	// add items to cart
	@PostMapping("/add")
	public Cart addToCart(@RequestBody Cart cart) {
		return cartService.addToCart(cart);
	}
	
	// Update cart item
	@PutMapping("/update/{cartId}")
	   public  Cart updateCart(@PathVariable Long cartId, @RequestBody Cart updatedCart) {
		return cartService.updateCart(cartId, updatedCart);
	   }
	   
	   // delete Cart
	@DeleteMapping("/delete/{cartId}")
	   public void deleteCart(@PathVariable Long cartId) {
		   cartService.deleteCart(cartId);
	   }
	   
	   // get specific cart item
	@GetMapping("/getCartItem/{cartId}")
	   public Cart getOneCartItem(@PathVariable Long cartId) {
		   return cartService.getOneCartItem(cartId);
	}
	
	// get all cart items of user
	@GetMapping("/getAllUserCartItems/{userId}")
		public List<Cart> getAllCartItems(@PathVariable Long userId){
			return cartService.getAllCartItems(userId);
		}

}
