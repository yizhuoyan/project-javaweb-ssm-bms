package entity;

public class BookEntity {

	private String id;
	/**isbn号*/
	private String isbn;
	/**书名*/
	private String name;
	/**
	 *书籍价格 单位分 
	 **/
	private int price;
	/**书的作者*/
	private AuthorEntity author; 
	
	
	
	
	
	public AuthorEntity getAuthor() {
		return author;
	}
	public void setAuthor(AuthorEntity author) {
		this.author = author;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", isbn=" + isbn + ", name=" + name
				+ ", price=" + price + ", author="  + "]";
	}
	
	
	
}
