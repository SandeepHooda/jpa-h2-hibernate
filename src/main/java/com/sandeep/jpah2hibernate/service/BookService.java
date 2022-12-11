package com.sandeep.jpah2hibernate.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sandeep.jpah2hibernate.repositories.BookRepository;
import com.sandeep.jpah2hibernate.test.entities.Book;
import com.sandeep.jpah2hibernate.test.entities.BookDTO;

@Service
@Transactional
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	EntityManager entityManager;
	
	public List<BookDTO> getAllBooks(){
		List<Book> allBooks = bookRepo.findAll();
		List<BookDTO> allBooksDto = allBooks.stream().map(book -> convertToDto(book) ).collect(Collectors.toList());
		return allBooksDto;
	}
	
	public void saveNewBook(long bookid) {
		
				entityManager.createNativeQuery("INSERT INTO BOOK ( id,name) VALUES (?,?)")
			      .setParameter(1, bookid)
			      .setParameter(2, "new Book "+bookid)
			      .executeUpdate();
				if (bookid == 200) {
					 throw new DataIntegrityViolationException("Throwing exception for demoing Rollback!!!");
				}
	}
	
	private BookDTO convertToDto(Book book) {
		return new BookDTO(book.getId(), book.getName());
	    

	}
	
}
