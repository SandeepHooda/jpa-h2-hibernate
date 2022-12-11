package com.sandeep.jpah2hibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandeep.jpah2hibernate.test.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
