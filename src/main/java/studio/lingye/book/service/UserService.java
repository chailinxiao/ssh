package studio.lingye.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio.lingye.book.dao.UserDao;
import studio.lingye.book.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User findById(Integer uid) {
		return userDao.findById(uid);
	}
	
	public List<User> findByExample(User user) {
		return userDao.findByExample(user);
	}
	
	public int saveUser(User user) {
		return userDao.saveUser(user);
	}
	
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	
	public void deleteUser(User user) {
		userDao.delUser(user);
	}
	
	public List<User> findByPage(User user, int offset, int pagesize) {
		return userDao.findByPage(user, offset, pagesize);
	}
}
