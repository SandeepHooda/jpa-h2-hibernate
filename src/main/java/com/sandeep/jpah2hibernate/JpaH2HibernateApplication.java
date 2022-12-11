package com.sandeep.jpah2hibernate;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JpaH2HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaH2HibernateApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
