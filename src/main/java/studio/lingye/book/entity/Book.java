package studio.lingye.book.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="book", catalog="ssh")
public class Book {
	
	@Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "native") //自定义主键生成策略 generator = name
    private int id;// 商品ID
	
	private String name;
	
	private String memo;
	
	private String isbn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
