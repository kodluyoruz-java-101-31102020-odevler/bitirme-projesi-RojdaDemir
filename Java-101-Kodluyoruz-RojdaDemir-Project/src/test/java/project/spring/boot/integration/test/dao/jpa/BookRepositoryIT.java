package project.spring.boot.integration.test.dao.jpa;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import project.spring.boot.dao.entity.Book;
import project.spring.boot.dao.jpa.repository.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource({ "classpath:application.properties" })
public class BookRepositoryIT {

	@Autowired
	private BookRepository bookRepository;
	
	
	@Test
	@Order(1)
	public void selectBookByBookNo() {
		
		Long maxId =bookRepository.findMaxId();
		Book book = bookRepository.findWithBookNo(maxId);
		
		Assert.assertNotNull(book);
		Assert.assertTrue(book.getBookNo() > 0);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	@Order(2)
	public void saveBook() {
		
		Long maxId =bookRepository.findMaxId();
		Long newbookId = maxId + 1;
		
		Book book = new Book();
		book.setBookNo(newbookId);
		book.setBookName("Kırlangıç Çığlığı");
		book.setBookAuthor("Ahmet Ümit");
		book.setPageCount(400L);
		book.setPublisher("Everest Yayınları");
		book.setPublishYear(2018L);
		book.setBookDescription("Açıklama");
		book.setReaderNote("Okur Açıklaması");
		
		bookRepository.save(book);
		
		book = bookRepository.findWithBookNo(newbookId);
		
		Assert.assertNotNull(book);
		Assert.assertTrue(book.getBookNo() > 0);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Order(3)
	public void updateBook() {
		
		Long maxId =bookRepository.findMaxId();
		Book book=bookRepository.findWithBookNo(maxId);
		
		book.setBookName("Kitap ismi");
		book.setBookAuthor("Franz Kafka");
	    book.setReaderNote("Okur");
		
		bookRepository.save(book);
		
		book = bookRepository.findWithBookNo(maxId);
		
		Assert.assertEquals("Kitap ismi", book.getBookName());
		Assert.assertEquals("Franz Kafka", book.getBookAuthor());
		Assert.assertEquals("Okur", book.getReaderNote());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Order(4)
	public void deleteBook() {
		
		Long maxId = bookRepository.findMaxId();
		Book book = bookRepository.findWithBookNo(maxId);
		
		bookRepository.delete(book);
		
		book = bookRepository.findWithBookNo(maxId);
		
		Assert.assertNull(book);
	}
}
