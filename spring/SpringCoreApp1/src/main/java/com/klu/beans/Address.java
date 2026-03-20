package com.klu.beans;

public class Address {

    // dependencies of type primitive
    private String street;
    private String city;
    private String state;

    // getters and setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // optional display method (useful for testing/output)
    public void displayAddressDetails() {
        System.out.println("Street:" + street);
        System.out.println("City:" + city);
        System.out.println("State:" + state);
    }
}
