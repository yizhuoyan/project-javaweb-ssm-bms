package service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import entity.AuthorEntity;
import entity.BookEntity;

public interface BookService {

	/**
	 * 录入一个作者
	 */
	@Transactional(readOnly=true)
	public void addAuthor(AuthorEntity e)throws Exception;
	/**
	 * 添加一本书
	 * @param e
	 * @throws Exception
	 */
	@Transactional
	public void addAuthor(BookEntity e, String authorId)throws Exception;
	
	/**
	 * 查看一本书的详情
	 * @param bookId 
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly=true)
	public BookEntity checkBookDetail(String bookId)throws Exception;
	/**
	 * 查看作者详情
	 * @param authorId
	 * @return
	 * @throws Exception
	 */
	public AuthorEntity checkAuthorDetail(String authorId)throws Exception;
}
