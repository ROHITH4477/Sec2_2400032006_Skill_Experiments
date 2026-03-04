package com.klu.beans;

import org.springframework.stereotype.Component;

//dependency class
@Component
public class Engine {
	public void start() {
		System.out.println("Engine Started");
	}

}
