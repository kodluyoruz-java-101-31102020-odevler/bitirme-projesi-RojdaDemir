package project.spring.boot.mock.test.controller;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import project.spring.boot.controller.BookController;
import project.spring.boot.service.BookService;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerMT {

	@Mock
	private BookService bookService;
	
	@InjectMocks
	private BookController bookController;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
}
