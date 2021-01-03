package project.spring.boot.web.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.spring.boot.dao.entity.Book;
import project.spring.boot.service.BookService;
import project.spring.boot.service.model.BookContext;


@Controller
@RequestMapping("/pages")
public class PageController {

	@Autowired
	private BookService bookService;
	
	
	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public String getEmployees(Model model) {
		
		List<Book> book = bookService.getAllBookList();
		model.addAttribute("books", book);
		
		return "thyme_book_list";
	}
	
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String getBookSavePage(BookContext bookContext) {
		
		return "thyme_book_save";
	}
	
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
    public String save(BookContext bookContext, BindingResult result, Model model) {
        

		bookService.save(bookContext);
		model.addAttribute("books", bookService.getAllBookList());
       
        return "thyme_book_list";
    }
	
	@RequestMapping(value="/book/{id}", method= RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long bookNo, Model model)
	
	{
		
		bookService.delete(bookNo);		
		
		List<Book> book = bookService.getAllBookList();
		model.addAttribute("books", book);
		return "thyme_book_list";
		
	}
	
}

	
	
	

