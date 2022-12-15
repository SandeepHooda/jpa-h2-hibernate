package com.sandeep.jpah2hibernate.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandeep.jpah2hibernate.test.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByYearOfPublish(int year);
	List<Book> findByYearOfPublish(int year,Pageable pageable);
}
