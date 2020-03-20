package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AuthorDao;
import dao.BookDao;
import entity.AuthorEntity;
import entity.BookEntity;
import service.BookService;
import util.SqlSessionUtil;
@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private AuthorDao adao;
	@Autowired
	private BookDao bdao;
	


	@Override
	public void addAuthor(AuthorEntity e) throws Exception {
		adao.insert(e);
	}

	@Override
	public void addAuthor(BookEntity e,String authorId) throws Exception {
		AuthorEntity au=adao.select("id", authorId);
		e.setAuthor(au);
		bdao.insert(e);
	}
	@Override
	public BookEntity checkBookDetail(String bookId) throws Exception {
		BookEntity b=bdao.select("id", bookId);
		return b;
	}
	@Override
	public AuthorEntity checkAuthorDetail(String authorId) throws Exception {
		AuthorEntity au=adao.select("id", authorId);
		return au;
	}
	

}
