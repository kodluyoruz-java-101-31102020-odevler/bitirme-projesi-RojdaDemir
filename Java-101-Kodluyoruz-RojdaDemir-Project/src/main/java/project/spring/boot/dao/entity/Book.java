package project.spring.boot.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "books")
public class Book implements Serializable {

	private static final long serialVersionUID = 456221378798987L;
	
	@Id
	@org.springframework.data.annotation.Id
	@Column(name = "book_ID")
	private Long bookNo;
	
	@Column(name = "book_Name")
	private String bookName;
	
	@Column(name = "book_Author")
	private String bookAuthor;
	
	@Column(name = "page_Count")
	private Long pageCount;
	
	@Column(name = "publisher")
	private String publisher;
	

	@Column(name = "publish_Year")
	private Long publishYear;

	
	@Column(name ="book_Description")
	private String bookDescription;
	
	
	@Column(name="reader_Note")
	private String readerNote;

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Long getPageCount() {
		return pageCount;
	}

	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Long getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(Long publishYear) {
		this.publishYear = publishYear;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getReaderNote() {
		return readerNote;
	}

	public void setReaderNote(String readerNote) {
		this.readerNote = readerNote;
	}
	
	
	
}


	
