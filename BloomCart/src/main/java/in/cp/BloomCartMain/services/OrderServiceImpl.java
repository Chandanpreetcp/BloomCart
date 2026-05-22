package in.cp.BloomCartMain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cp.BloomCartMain.entities.Order;
import in.cp.BloomCartMain.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired 
	private OrderRepository orderRepo;

	// place order
	@Override
	public Order placeOrder(Order order) {
		return orderRepo.save(order);
	}

	// get specific user's orders
	@Override
	public List<Order> getOrdersByUsers(Long userId) {
		return orderRepo.findAllByUserUserId(userId);
	}

	// Get order by id
	@Override
    public Order getOrderById(Long orderId) {
    	return orderRepo.getById(orderId);
    }

	// update order
	@Override
	public Order updateOrder(Long orderId, Order updatedOrder) {
		Order existingOrder =  orderRepo.getById(orderId);
		existingOrder.setUser(updatedOrder.getUser());
		existingOrder.setStatus(updatedOrder.getStatus());
		existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
		existingOrder.setOrderDate(updatedOrder.getOrderDate());
		existingOrder.setOrderId(updatedOrder.getOrderId());

		return orderRepo.save(updatedOrder);
	}

	// delete order
	@Override
	public void deleteOrder(Long orderId) {
		orderRepo.deleteById(orderId);
		
	}
}
