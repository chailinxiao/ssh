package studio.lingye.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio.lingye.book.dao.OrderDao;
import studio.lingye.book.entity.Order;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	
	public Order findById(Integer uid) {
		return orderDao.findById(uid);
	}
	
	public List<Order> findByExample(Order Order) {
		return orderDao.findByExample(Order);
	}
	
	public int saveOrder(Order Order) {
		return orderDao.saveOrder(Order);
	}
	
	public void updateOrder(Order Order) {
		orderDao.updateOrder(Order);
	}
	
	public void deleteOrder(Order Order) {
		orderDao.delOrder(Order);
	}
	
	public List<Order> findByPage(Order order, int offset, int pagesize) {
		return orderDao.findByPage(order, offset, pagesize);
	}
}
