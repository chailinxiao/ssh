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

import studio.lingye.book.dao.UserDao;
import studio.lingye.book.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	private HibernateTemplate template;

	@Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.template = new HibernateTemplate(sessionFactory);
    }
	
	@Override
	public User findById(Integer uid) {
		return template.get(User.class, uid);
	}

	@Override
	public int saveUser(final User user) {
		template.save(user);
		return 0;
	}
	
	@Override
	public void updateUser(final User user) {
		template.update(user);
	}

	@Override
	public List<User> findByExample(User user) {
		return template.findByExample(user);
	}

	@Override
	public void delUser(final User user) {
		template.delete(user);
	}
	
	public List<User> findByPage(User user, final int offset, final int pagesize) {
		return template.execute(new HibernateCallback<List<User>>() {
			@Override
			public List<User> doInHibernate(Session session) throws HibernateException {
				String hql = "select id, age, mobile, password, role, sex, username from User"; 
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
