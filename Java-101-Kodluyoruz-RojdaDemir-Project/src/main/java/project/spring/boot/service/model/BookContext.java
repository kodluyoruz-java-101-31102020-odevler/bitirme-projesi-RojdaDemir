package project.spring.boot.service.model;
import java.io.Serializable;

public class BookContext  implements Serializable {

	private static final long serialVersionUID = 78452515445749L;
	
    private Long bookNo;
	private String bookName;
	private String bookAuthor;
	private Long pageCount;
	private String publisher;
	private Long publishYear;
	private String bookDescription;
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

	public void setReaderNote(String readerNote) {
		this.readerNote = readerNote;
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
}
