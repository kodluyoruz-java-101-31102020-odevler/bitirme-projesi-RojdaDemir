package project.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.spring.boot.dao.entity.Book;
import project.spring.boot.service.BookService;
import project.spring.boot.service.model.BookContext;


@RestController
@RequestMapping("/collection")
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public Book findByBookNo(@PathVariable("id") Long bookNo) {
		
		return bookService.findByBookNo(bookNo);
	}
	
	@RequestMapping(value = "/book/{bookName}", method = RequestMethod.GET)
	public Book findByBookName(@PathVariable("bookName") String bookName) {
		
		return bookService.findByBookName(bookName);
	}
	
	
	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public List<Book> getAllEmployeeList() {
		
		return bookService.getAllBookList();
	}
	
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public Long save(@RequestBody BookContext bookContext) {
		
		return bookService.save(bookContext);
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.PUT)
	public Long update(@RequestBody BookContext bookContext) {
		
		return bookService.update(bookContext);
	}
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	public Long delete(@PathVariable("id") Long bookNo) {
		
		return bookService.delete(bookNo);
	}
	
   
	
}
