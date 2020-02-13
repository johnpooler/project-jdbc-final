package com.qa.testcontroller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.controller.CustomerController;
import com.qa.persistence.domain.*;
import com.qa.services.*;

public class CustomerControllerTest {


	@Mock
	private CustomerServices customerServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private CustomerController customerController;


	@Test
	public void readAllTest() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Jesus"));
		customers.add(new Customer("Restituto"));
		customers.add(new Customer("Nico"));
		Mockito.when(customerServices.readAll()).thenReturn(customers);
		assertEquals(customers, customerController.readAll());
	}
	
	@Test
	public void createTest() {
		String name = "Juan";
		Mockito.doReturn(name).when(customerController).getInput();
		Customer customer = new Customer(name);
		Customer savedCustomer = new Customer(1, "Juan");
		Mockito.when(customerServices.create(customer)).thenReturn(savedCustomer);
		assertEquals(savedCustomer, customerController.create());
	}

	/**
	 * 
	 */
	@Test
	public void updateTest() {
		String id = "1";
		String name = "Thompson";
		Mockito.doReturn(id, name).when(customerController).getInput();
		Customer customer = new Customer(1, name);
		Mockito.when(customerServices.update(customer)).thenReturn(customer);
		assertEquals(customer, customerController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(customerController).getInput();
		customerController.delete();
		Mockito.verify(customerServices, Mockito.times(1)).delete(1);
	}
}
