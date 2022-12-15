package com.sandeep.jpah2hibernate.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "BOOK")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@Id
 
    private Long id;
    private String name;
    private int yearOfPublish;

}
