package project.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.spring.boot.dao.entity.Book;
import project.spring.boot.dao.jpa.repository.BookRepository;
import project.spring.boot.service.model.BookContext;

@Service
public class BookService implements BookServiceImpl {

	@Autowired
	private BookRepository bookRepository;


	public Book findByBookNo(Long bookNo) {
		
		return bookRepository.findWithBookNo(bookNo);
	}
	
	public Book findByBookName(String bookName) {
		
		return bookRepository.findWithBookName(bookName);
	}
	
	
	public List<Book> getAllBookList() {
		
		return bookRepository.getAllBookList();
	}
	
	@Transactional
	public Long save(BookContext bookContext) {
		
		Long maxId = bookRepository.findMaxId() + 1;
		
		Book book= new Book();
		book.setBookNo(maxId);
		book.setBookName(bookContext.getBookName());
		book.setBookAuthor(bookContext.getBookAuthor());
		book.setPageCount(bookContext.getPageCount());
		book.setPublisher(bookContext.getPublisher());
		book.setPublishYear(bookContext.getPublishYear());
		book.setBookDescription(bookContext.getBookDescription());
		book.setReaderNote(bookContext.getReaderNote());
		
        book = bookRepository.save(book);
        
	    return book.getBookNo();
	}
	
	@Transactional
	public Long update(BookContext bookContext) {
		
		Book book = bookRepository.findWithBookNo(bookContext.getBookNo());
		if(book == null)
		{
			throw new RuntimeException(bookContext.getBookNo() + "Kitabın ID değeri bulunamadı!");
		}
		
	    book.setBookName(bookContext.getBookName());
	    book.setBookAuthor(bookContext.getBookAuthor());
	    book.setPageCount(bookContext.getPageCount());
	    book.setPublisher(bookContext.getPublisher());
	    book.setPublishYear(bookContext.getPublishYear());
	    book.setBookDescription(bookContext.getBookDescription());
	    book.setReaderNote(bookContext.getReaderNote());
	    
	    bookRepository.save(book);
	    
	    return book.getBookNo();
	    
	}
	@Transactional
	public Long delete(Long bookNo) {
		
		bookRepository.deleteById(bookNo);
		return bookNo;
	}
	
}
