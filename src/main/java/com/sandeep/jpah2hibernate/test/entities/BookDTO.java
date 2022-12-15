package com.sandeep.jpah2hibernate.test.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class BookDTO {
	private Long id;
    private String name;
    private int yearOfPublish;

}
