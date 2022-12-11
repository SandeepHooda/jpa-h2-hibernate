package com.sandeep.jpah2hibernate.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.jpah2hibernate.service.BookService;
import com.sandeep.jpah2hibernate.test.entities.BookDTO;

@RestController
public class TestEndpoint {
	@Autowired
	BookService bookSrv;
	
	@GetMapping(value="/sayhello", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<BookDTO> sayhello() {
		List<BookDTO> allBooks= bookSrv.getAllBooks();
		allBooks.stream().forEach(System.out::println);
		return allBooks;
	}
	
	@GetMapping(value="/savebook", produces = MediaType.APPLICATION_JSON_VALUE)
	public Long savebook(@RequestParam (name="bookid") long bookid) {
		bookSrv.saveNewBook(bookid);
	
	return bookid;
}

}
