package in.cp.BloomCartMain.services;

import java.util.List;

import in.cp.BloomCartMain.entities.Order;

public interface OrderService {
	public Order placeOrder(Order order);
	public List<Order> getOrdersByUsers(Long userId);
	public Order getOrderById(Long orderId);
	public Order updateOrder(Long orderId , Order updatedOrder);
	public void deleteOrder(Long orderId);
}
