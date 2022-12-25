package com.rohan.lms.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rohan.lms.jsondeserializer.BookAuthorNameDeserializer;

@Entity
public class Book {

	@Id
	@Length(min = 12, max = 13)
	private String isbn;

	private String bookName;
	private String bookType;
	
//	@JsonDeserialize(using=BookAuthorNameDeserializer.class)
	@ElementCollection
	private List<String> authorName;
	
	private Long yearOfPublication;
	private boolean bookAvailability;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp addedAt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp updatedAt;

//	private Member memberId;

	public Book() {
	}

	public Book(String isbn, String bookName, String bookType, List<String> authorName, Long yearOfPublication) {
		super();
		this.isbn = isbn;
		this.bookName = bookName;
		this.bookType = bookType;
		this.authorName = authorName;
		this.yearOfPublication = yearOfPublication;
	}

	public Book(@Length(min = 12, max = 13) String isbn, String bookName, String bookType, List<String> authorName,
			Long yearOfPublication, boolean bookAvailability, Timestamp addedAt) {
		super();
		this.isbn = isbn;
		this.bookName = bookName;
		this.bookType = bookType;
		this.authorName = authorName;
		this.yearOfPublication = yearOfPublication;
		this.bookAvailability = bookAvailability;
		this.addedAt = addedAt;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String ibsn) {
		this.isbn = ibsn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public List<String> getAuthorName() {
		return authorName;
	}

	public void setAuthorName(List<String> authorName) {
		this.authorName = authorName;
	}

	public Long getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(Long yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public boolean isBookAvailability() {
		return bookAvailability;
	}

	public void setBookAvailability(boolean bookAvailability) {
		this.bookAvailability = bookAvailability;
	}

}
