package entity;

import java.util.Date;
import java.util.List;

/**
 * 作者
 * @author Administrator
 *
 */
public class AuthorEntity {

	private String id;
	//姓名
	private String name;
	//出生年月
	private Date birthDay;
	//死亡年月
	private Date deadDay;
	//年龄
	private int age;
	


	public Date getBirthDay() {
		return birthDay;
	}


	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}


	public Date getDeadDay() {
		return deadDay;
	}


	public void setDeadDay(Date deadDay) {
		this.deadDay = deadDay;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	//简介
	private String intro;
	/**
	 * 作者写的书
	 */
	private List<BookEntity> books;

	public List<BookEntity> getBooks() {
		return books;
	}


	public void setBooks(List<BookEntity> books) {
		this.books = books;
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


	public String getIntro() {
		return intro;
	}


	public void setIntro(String intro) {
		this.intro = intro;
	}


	@Override
	public String toString() {
		return "AuthorEntity [id=" + id + ", name=" + name + ", birthDay=" + birthDay + ", deadDay=" + deadDay
				+ ", age=" + age + ", intro=" + intro + ", books=" + books + "]";
	}


	
	
}
