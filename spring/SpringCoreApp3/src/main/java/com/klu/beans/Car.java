package com.klu.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Dependent Class
@Component
public class Car {
	//props
	@Autowired
	private Engine engine;
	
	public void drive() {
		engine.start();
		System.out.println("Drive the Car..");
	}

}
