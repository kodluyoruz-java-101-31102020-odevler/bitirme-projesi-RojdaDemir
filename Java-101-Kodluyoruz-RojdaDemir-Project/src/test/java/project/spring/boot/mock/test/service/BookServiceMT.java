package project.spring.boot.mock.test.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import project.spring.boot.dao.entity.Book;
import project.spring.boot.dao.jpa.repository.BookRepository;
import project.spring.boot.service.BookService;
import project.spring.boot.service.model.BookContext;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceMT {

	@Mock
    private BookRepository bookRepository;

	
	@InjectMocks
	private BookService bookService;
	
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void queryBook() {
		
		Book book = new Book();
	    book.setBookNo(10L);
	    book.setBookName("Sineklerin Tanrısı");
	    book.setBookAuthor("yazar");
	    book.setPageCount(182L);
	    book.setPublisher("yayıncı");
	    book.setPublishYear(1788L);
	    book.setBookDescription("Açıklama buradadır");
	    book.setReaderNote("Not");
	    
	    Book book3 = new Book();
	    book3.setBookNo(11L);
	    book3.setBookName("Suç ve Ceza");
	    book3.setBookAuthor("Fyodor Dostoyevski");
	    book3.setPageCount(600L);
	    book3.setPublisher("Hasan Ali Yücel Klasikleri");
	    book3.setPublishYear(1899L);
	    book3.setBookDescription("Açıklama");
	    book3.setReaderNote("Not yazılmıştır.");
	   
		 
	    Mockito
	    	.when(bookRepository.findWithBookNo(10L))
	    	.thenReturn(book);
	    
	    Mockito
	    	.when(bookRepository.findWithBookNo(11L))
	    	.thenReturn(book3);
	    
		
       Book book2 = bookService.findByBookNo(11L);
		
		Assert.assertNotNull(book2);
		Assert.assertTrue(book2.getBookNo() > 0);
	}
	
	@Test
	public void queryAllBooks() {
		
		Book book1 = new Book();
		book1.setBookNo(10L);
		book1.setBookName("Sineklerin Tanrısı");
		book1.setBookAuthor("yazar");
		book1.setPageCount(182L);
		book1.setPublisher("yayıncı");
		book1.setPublishYear(1788L);
		book1.setBookDescription("Açıklama buradadır");
		book1.setReaderNote("Not");
	    
	    Book book2 = new Book();
	    
	    book2.setBookNo(10L);
	    book2.setBookName("Sineklerin Tanrısı");
	    book2.setBookAuthor("yazar");
	    book2.setPageCount(182L);
	    book2.setPublisher("yayıncı");
	    book2.setPublishYear(1788L);
	    book2.setBookDescription("Açıklama buradadır");
	    book2.setReaderNote("Not");
	 
	    
	    
		List<Book> books = Arrays.asList(book1, book2);
		
		Mockito
			.when(bookRepository.getAllBookList())
			.thenReturn(books);
		
		
		
		List<Book> books2 = bookService.getAllBookList();
		
		Assert.assertNotNull(books2);
		Assert.assertTrue(books2.size() > 0);
	}
	
	@Test
	public void saveBook() {
		
		BookContext bookContext = new BookContext();
		bookContext.setBookName("Sineklerin Tanrısı");
		bookContext.setBookAuthor("yazar");
		bookContext.setPageCount(182L);
		bookContext.setPublisher("yayıncı");
		bookContext.setPublishYear(1788L);
		bookContext.setBookDescription("Açıklama buradadır");
		bookContext.setReaderNote("Not");
		
	    Long maxbookId = 100L;
	    
		Book book = new Book();
	    book.setBookNo(maxbookId + 1);
	    book.setBookName(bookContext.getBookName());
	    book.setBookAuthor(bookContext.getBookAuthor());
	    book.setPageCount(bookContext.getPageCount());
	    book.setPublisher(bookContext.getPublisher());
	    book.setPublishYear(bookContext.getPublishYear());
	    book.setBookDescription(bookContext.getBookDescription());
	    book.setReaderNote(bookContext.getReaderNote());
	
	    Mockito
			.when(bookRepository.findMaxId())
			.thenReturn(maxbookId);
	    
		Mockito
			.when(bookRepository.save(book))
			.thenReturn(book);
		
		
		long bookId = bookService.save(bookContext);
		
		Assert.assertEquals(101L, bookId);
	}
	

	
	private void prepareMockTestRuleBookQueryByBookNo() {
		
		  Book book = new Book();
		  book.setBookNo(10L);
		  book.setBookName("Sineklerin Tanrısı");
		  book.setBookAuthor("yazar");
		  book.setPageCount(182L);
		  book.setPublisher("yayıncı");
		  book.setPublishYear(1788L);
		  book.setBookDescription("Açıklama buradadır");
		  book.setReaderNote("Not");
		 
	    Mockito
	    	.when(bookRepository.findWithBookNo(10L))
	    	.thenReturn(book);
		
	}
	
	private void prepareMockTestRuleBookProfiles() {
		
		Book book1 = new Book();
		book1.setBookNo(10L);
		book1.setBookName("Sineklerin Tanrısı");
		book1.setBookAuthor("yazar");
		book1.setPageCount(182L);
		book1.setPublisher("yayıncı");
		book1.setPublishYear(1788L);
		book1.setBookDescription("Açıklama buradadır");
		book1.setReaderNote("Not");
	    
		Book book2 = new Book();
		book2.setBookNo(10L);
		book2.setBookName("Sineklerin Tanrısı");
		book2.setBookAuthor("yazar");
		book2.setPageCount(182L);
		book2.setPublisher("yayıncı");
		book2.setPublishYear(1788L);
		book2.setBookDescription("Açıklama buradadır");
		book2.setReaderNote("Not");
	    
	    
		List<Book> books = Arrays.asList(book1, book2);
		
		Mockito
			.when(bookRepository.getAllBookList())
			.thenReturn(books);
		
	}
	
	private void prepareMockTestRuleBookSave(BookContext bookContext) {
		
		   Long bookId = 100L;
		    Book book = new Book();
		    book.setBookNo(bookId + 1);
		    book.setBookName(bookContext.getBookName());
		    book.setBookAuthor(bookContext.getBookAuthor());
		    book.setPageCount(bookContext.getPageCount());
		    book.setPublisher(bookContext.getPublisher());
		    book.setPublishYear(bookContext.getPublishYear());
		    book.setBookDescription(bookContext.getBookDescription());
		    book.setReaderNote(bookContext.getReaderNote());
		
	    Mockito
			.when(bookRepository.findMaxId())
			.thenReturn(bookId);
	    
		Mockito
			.when(bookRepository.save(book))
			.thenReturn(book);
	}
	
	
}
