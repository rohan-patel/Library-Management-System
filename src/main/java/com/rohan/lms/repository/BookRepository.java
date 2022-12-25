package com.rohan.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohan.lms.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {
	
	Book findByIsbn(String isbn);

}
