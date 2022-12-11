package com.sandeep.jpah2hibernate.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.jpah2hibernate.repositories.BookRepository;
import com.sandeep.jpah2hibernate.test.entities.Book;
import com.sandeep.jpah2hibernate.test.entities.BookDTO;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	public List<BookDTO> getAllBooks(){
		List<Book> allBooks = bookRepo.findAll();
		List<BookDTO> allBooksDto = allBooks.stream().map(book -> convertToDto(book) ).collect(Collectors.toList());
		return allBooksDto;
	}
	
	private BookDTO convertToDto(Book book) {
		return new BookDTO(book.getId(), book.getName());
	    

	}
	
}
