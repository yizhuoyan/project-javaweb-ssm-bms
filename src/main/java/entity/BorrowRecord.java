package entity;

import java.util.Date;
/**
 * 借阅记录
 * @author Administrator
 *
 */
public class BorrowRecord {

	private String id;
	private BookEntity book;
	private UserEntity borrower;
	private Date borrowTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BookEntity getBook() {
		return book;
	}

	public void setBook(BookEntity book) {
		this.book = book;
	}

	public UserEntity getBorrower() {
		return borrower;
	}

	public void setBorrower(UserEntity borrower) {
		this.borrower = borrower;
	}

	public Date getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}
	
}
