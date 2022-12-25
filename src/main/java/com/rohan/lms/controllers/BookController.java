package com.rohan.lms.controllers;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.lms.exception.EntityAlreadyExistsException;
import com.rohan.lms.exception.InsufficientDataException;
import com.rohan.lms.model.Book;
import com.rohan.lms.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookRepository bookRepo;

	/*
	 * GET - get all books GET - get a book by isbn POST - add a book to library PUT
	 * - update a book details by book id DELETE - remove a book from library
	 */

	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> bookList = new ArrayList<Book>();
		bookRepo.findAll().forEach(bookList::add);

		return new ResponseEntity<>(bookList, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Book> getOneBook(@RequestParam String isbn) {
		Optional<Book> optionalBook = bookRepo.findById(isbn);

		Book book = optionalBook.get();

		if (book == null) {
			throw new EntityNotFoundException("Book with isbn " + isbn + "not found in the database");
		}
//		System.out.println(book.get);

		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {

		if (bookRepo.findById(book.getIsbn()).isPresent() == true) {
			throw new EntityAlreadyExistsException(
					"Book with isbn " + book.getIsbn() + "already exists in the database");
		}

		Book _book = bookRepo.save(new Book(book.getIsbn(), book.getBookName(), book.getBookType(),
				book.getAuthorName(), book.getYearOfPublication(), true, new Timestamp(new Date().getTime())));

		return new ResponseEntity<>(_book, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Book> updateBook(@RequestBody Map<String, Object> payload) {

		if (payload.get("isbn") == null) {
			throw new InsufficientDataException("Please provide a valid ISBN of the book present in the database");
		}

		Optional<Book> optionalBook = bookRepo.findById((String) payload.get("isbn"));
		Book book = optionalBook.get();

		if (book == null) {
			throw new EntityNotFoundException("Book with isbn " + payload.get("isbn") + "not found in the database");
		}
		
		List<String> authorNames = (List<String>) payload.get("authorName");
		System.out.println(authorNames);

//		for (Map.Entry<String, String> entry : payload.entrySet()) {
//			if (entry.getKey() != "isbn") {
//				switch (entry.getKey()) {
//				case "bookName":
//					book.setBookName(payload.get("bookName"));
//				case "bookType":
//					book.setBookType(payload.get("bookType"));
//				case "authorName":
//					book.setAuthorName(payload.get("authorName"));
//				case "yearOfPublication":
//					book.setYearOfPublication(Long.parseLong(payload.get("yearOfPublication")));
//				}
//			}
//		}

		return null;
	}

}
