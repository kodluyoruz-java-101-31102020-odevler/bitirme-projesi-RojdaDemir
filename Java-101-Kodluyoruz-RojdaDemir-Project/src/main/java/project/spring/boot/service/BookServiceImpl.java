package project.spring.boot.service;

import java.util.List;

import project.spring.boot.dao.entity.Book;
import project.spring.boot.service.model.BookContext;


public interface BookServiceImpl {

	public Book findByBookNo(Long bookNo);
	public List<Book> getAllBookList();
	public Long save(BookContext bookContext);
	public Long update(BookContext bookContext);
	public Long delete(Long bookNo);
}
