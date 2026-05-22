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

import in.cp.BloomCartMain.entities.Order;
import in.cp.BloomCartMain.services.OrderService;

@RestController
@RequestMapping("/Order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	// place order
	@PostMapping("/placeOrder")
	public Order placeOrder(@RequestBody Order order) {
		return orderService.placeOrder(order);
	}
	
	// get specific user's order
	@GetMapping("/getUserOrder/{userId}")
	public List<Order> getOrdersByUsers(@PathVariable Long userId) {
		return orderService.getOrdersByUsers(userId);
	}
	
	// Get order by id
	@GetMapping("/getOrderById/{orderId}")
	    public Order getOrderById(@PathVariable Long orderId) {
	    	return orderService.getOrderById(orderId);
	    }
	    
	    // update order
	@PutMapping("/update/{orderId}")
	    public Order updateOrder(@PathVariable Long orderId , @RequestBody Order updatedOrder) {
			return orderService.updateOrder(orderId, updatedOrder);
	    }

	    // delete order
	@DeleteMapping("/delete/{orderId}")
	    public void deleteOrder(@PathVariable Long orderId) {
	    	orderService.deleteOrder(orderId);
	    }
}
