package studio.lingye.book.dao;

import java.util.List;

import studio.lingye.book.entity.Book;

public interface BookDao {
	
	List<Book> findByExample(Book Book);
	
	Book findById(Integer uid);
	
	int saveBook(Book Book);
	
	void updateBook(Book Book);
	
	void delBook(Book Book);
	
}
