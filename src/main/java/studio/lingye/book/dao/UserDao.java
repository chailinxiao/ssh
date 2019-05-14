package studio.lingye.book.dao;

import java.util.List;

import studio.lingye.book.entity.User;

public interface UserDao {
	
	List<User> findByExample(User user);
	
	User findById(Integer uid);
	
	int saveUser(User user);
	
	void updateUser(User user);
	
	void delUser(User user);
	
	List<User> findByPage(User user, int offset, int pagesize);
}
