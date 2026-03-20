package com.klu.beans;

public class Address {
	// props
	private String street;
	private String city;
	private String state;
	
	// setters
	public void setStreet(String street) {
		this.street = street;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	// method to get address details
	public void getAddressDetails() {
		System.out.println("Street : " + street);
		System.out.println("City   : " + city);
		System.out.println("State  : " + state);
	}
}
