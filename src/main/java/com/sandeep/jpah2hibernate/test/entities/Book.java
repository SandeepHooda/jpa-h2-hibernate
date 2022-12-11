package com.sandeep.jpah2hibernate.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.ToString;

@Entity(name = "BOOK")
@ToString
@Getter
public class Book {
	@Id
    @GeneratedValue
    private Long id;
    private String name;

}
