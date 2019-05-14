package studio.lingye.book.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import studio.lingye.book.dao.OrderDao;
import studio.lingye.book.entity.Order;

@Repository
public class OrderDaoImpl implements OrderDao{
	
	private HibernateTemplate template;

	@Autowired
    public OrderDaoImpl(SessionFactory sessionFactory) {
        this.template = new HibernateTemplate(sessionFactory);
    }
	
	@Override
	public Order findById(Integer uid) {
		return template.get(Order.class, uid);
	}

	@Override
	public int saveOrder(final Order order) {
		template.save(order);
		return 0;
	}
	
	@Override
	public void updateOrder(final Order order) {
		template.update(order);
	}

	@Override
	public List<Order> findByExample(Order order) {
		return template.findByExample(order);
	}

	@Override
	public void delOrder(final Order order) {
		template.delete(order);
	}
	
	public List<Order> findByPage(Order Order, final int offset, final int pagesize) {
		return template.execute(new HibernateCallback<List<Order>>() {
			@Override
			public List<Order> doInHibernate(Session session) throws HibernateException {
				String hql = "select id, age, mobile, password, role, sex, Ordername from Order"; 
				Query createQuery = session.createQuery(hql);
				createQuery.setFirstResult(offset);
				createQuery.setMaxResults(pagesize);
				List list = createQuery.list();
				return list;
			}
		});
	}
	
	public int count() { 
		Object execute = template.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				String hql = "SELECT COUNT(p.id) from ShbbsCategory AS p "; 
				Query createQuery = session.createQuery(hql);
				List list = createQuery.list(); 
				return list; 
			}
		});
		return 2;
	}
	
}
