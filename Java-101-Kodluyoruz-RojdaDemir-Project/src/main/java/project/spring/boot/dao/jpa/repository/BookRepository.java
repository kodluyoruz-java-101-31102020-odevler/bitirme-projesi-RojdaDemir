package project.spring.boot.dao.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.spring.boot.dao.entity.Book;
import project.spring.boot.service.model.BookContext;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	@Query(value = "SELECT b FROM Book b WHERE b.bookNo = :bookNo")
	public Book findWithBookNo(@Param("bookNo") Long bookNo);
	
	@Query(value="SELECT b FROM Book b WHERE b.bookName = :bookName")
	public Book findWithBookName(@Param("bookName") String bookName);
	
	@Query(value = "SELECT MAX(b.bookNo) FROM Book b")
	public Long findMaxId();
	
	@Query(value = "SELECT b FROM Book b")
	public List<Book> getAllBookList();
	
	@Query(value="Insert Into Book (bookName, bookAuthor, pageCount, publisher,publishYear, bookDescription, readerNote,bookNo) Values(?,?,?,?,?,?,?,?)",
			nativeQuery = true)
	public Long save(BookContext bookContext);
	
	@Query(value= "DELETE FROM Book b WHERE b.bookNo = :bookNo")
    public void deleteById(@Param("bookNo") Long bookNo);
	
}
