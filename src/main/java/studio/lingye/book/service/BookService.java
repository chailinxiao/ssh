package studio.lingye.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio.lingye.book.dao.BookDao;
import studio.lingye.book.entity.Book;

@Service
public class BookService {

	@Autowired
	private BookDao BookDao;
	
	public Book findById(Integer uid) {
		return BookDao.findById(uid);
	}
	
	public List<Book> findByExample(Book Book) {
		return BookDao.findByExample(Book);
	}
	
	public int saveBook(Book Book) {
		return BookDao.saveBook(Book);
	}
	
	public void updateBook(Book Book) {
		BookDao.updateBook(Book);
	}
	
	public void deleteBook(Book Book) {
		BookDao.delBook(Book);
	}
	
}
