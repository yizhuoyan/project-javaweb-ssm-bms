package entity;

import java.util.List;

/**
 * 用户
 * @author Administrator
 *
 */
public class UserEntity {

	private String id;
	
	private String name;
	
	private String account;
	
	private String password;
	
	
	
	private List<BorrowRecord> borrows;


	public List<BorrowRecord> getBorrows() {
		return borrows;
	}

	public void setBorrows(List<BorrowRecord> borrows) {
		this.borrows = borrows;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
