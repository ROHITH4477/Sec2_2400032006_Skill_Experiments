package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.klu.beans.Address;

public class AddressApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        Address addr = context.getBean("address", Address.class);

        System.out.println("Address Details:");
        addr.displayAddressDetails();
    }
}

