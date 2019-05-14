package studio.lingye.book.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import studio.lingye.book.dao.BookDao;
import studio.lingye.book.entity.Book;

@Repository
public class BookDaoImpl implements BookDao{
	
	private HibernateTemplate template;

	@Autowired
    public BookDaoImpl(SessionFactory sessionFactory) {
        this.template = new HibernateTemplate(sessionFactory);
    }
	
	@Override
	public Book findById(Integer uid) {
		return template.get(Book.class, uid);
	}

	@Override
	public int saveBook(Book Book) {
		template.save(Book);
		return 0;
	}

	@Override
	public List<Book> findByExample(Book Book) {
		return template.findByExample(Book);
	}

	@Override
	public void delBook(Book Book) {
		template.delete(Book);
	}

	@Override
	public void updateBook(Book Book) {
		template.update(Book);
	}
	
}
