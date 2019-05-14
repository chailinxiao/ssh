package studio.lingye.book.dao;

import java.util.List;

import studio.lingye.book.entity.Order;

public interface OrderDao {
	
	List<Order> findByExample(Order Order);
	
	Order findById(Integer uid);
	
	int saveOrder(Order Order);
	
	void updateOrder(Order Order);
	
	void delOrder(Order Order);
	
	List<Order> findByPage(Order order, int offset, int pagesize);
}
