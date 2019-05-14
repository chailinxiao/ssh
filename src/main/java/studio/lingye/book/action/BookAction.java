package studio.lingye.book.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import studio.lingye.book.entity.Book;
import studio.lingye.book.service.BookService;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Namespace("/book")
public class BookAction extends ActionSupport {

	private static final long serialVersionUID = -5305173280179452973L;

	@Autowired
	private BookService bookService;
	
	HttpServletRequest request = ServletActionContext.getRequest();

	int bid;
	
	int page = 1;
	
	@Action(value = "/booklist", results = { @Result(name = "booklist", location = "/pages/back/books/books_list.jsp") })
	public String userlist() {
		Book user = new Book();
		List<Book> list = bookService.findByExample(user);
		request.getSession().setAttribute("allItems", list);
		
		return "booklist";
	}

	@Action(value = "/bookadd", results = { @Result(name = "bookadd", location = "/pages/back/books/books_insert.jsp") })
	public String bookadd() {
		if(bid != 0) {
			Book user = bookService.findById(bid);
			request.setAttribute("book", user);
		}
		return "bookadd";
	}

	@Action(value = "/delBook", results = { @Result(name = "booklist", location = "/pages/back/books/books_list.jsp")})
	public String delBook() {
		if(bid != 0) {
			Book user = new Book();
			user.setId(bid);
			bookService.deleteBook(user);
		}
		
		Book uu = new Book();
		List<Book> uList = bookService.findByExample(uu);
		request.getSession().setAttribute("allItems", uList);
		return "booklist";
	}
	
	@Action(value = "/bookCreate", results = { 
			@Result(name = "booklist", location = "/pages/back/books/books_list.jsp"),
			@Result(name = "bookCreate", location = "/pages/back/books/books_insert.jsp") 
		})
	public String create() {
		String name = request.getParameter("name");
		if (StringUtils.isNotEmpty(name)) {
			int iId = 0;
			try{
				iId = Integer.parseInt(request.getParameter("id"));
			}catch(Exception e){}
			
			String isbn = request.getParameter("isbn");
			String memo = request.getParameter("memo");
			
			Book user = new Book();
			user.setMemo(memo);
			user.setIsbn(isbn);
			user.setName(name);
			if (iId > 0) {
				user.setId(iId);
				bookService.updateBook(user);
			} else {
				bookService.saveBook(user);
			}
			Book uu = new Book();
			List<Book> uList = bookService.findByExample(uu);
			request.getSession().setAttribute("allItems", uList);
			return "booklist";
		} else {
			return  "bookCreate";
		}
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}
	
	
	
}
