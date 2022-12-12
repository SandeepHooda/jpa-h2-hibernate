package com.sandeep.jpah2hibernate.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import com.sandeep.jpah2hibernate.repositories.BookRepository;
import com.sandeep.jpah2hibernate.test.entities.Book;
import com.sandeep.jpah2hibernate.test.entities.BookDTO;

@Service

public class BookService {

	@Autowired
	BookRepository bookRepo;
	

	
	 @PersistenceContext
	EntityManager entityManager;
	
	public List<BookDTO> getAllBooks(){
		List<Book> allBooks = bookRepo.findAll();
		List<BookDTO> allBooksDto = allBooks.stream().map(book -> convertToDto(book) ).collect(Collectors.toList());
		return allBooksDto;
	}
	public BookDTO findbook(long bookid){
		Book book =  entityManager.find(Book.class, bookid);
		return new BookDTO(book.getId(), book.getName());
	}
	@Transactional
	public void saveNewBook(long bookid) {
		
		
		
		  entityManager.createNativeQuery("INSERT INTO BOOK ( id,name) VALUES (?,?)")
		  .setParameter(1, bookid) 
		  .setParameter(2, "new Book "+bookid)
		  .executeUpdate();
		 
		  bookid = bookid *2;
		
		 Book newBook = new Book(bookid, "a New book "+bookid);
		 
		 entityManager.persist(newBook);
		 System.out.println(" Inserted books ");

				if (bookid == 200) {
					 throw new DataIntegrityViolationException("Throwing exception for demoing Rollback!!!");
				}
	}
	
	private BookDTO convertToDto(Book book) {
		return new BookDTO(book.getId(), book.getName());
	    

	}
	
}
