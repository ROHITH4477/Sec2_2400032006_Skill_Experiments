package com.klu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.klu.beans.Address;
import com.klu.beans.Student;

@Configuration
public class AppConfig {

	@Bean
	public Student getStudent() {
		// create Student object
		Student s = new Student();
		
		// assign primitive values
		s.setSid(1001);
		s.setSname("Rohith");
		s.setEmail("rohith@gmail.com");
		
		// return student object
		return s;
	}

	@Bean
	public Address getAddress() {
		// create Address object
		Address addr = new Address();
		
		addr.setStreet("Weavers Colony");
		addr.setCity("Mangalagiri");
		addr.setState("Andhra Pradesh");
		
		// return address object
		return addr;
	}
}
