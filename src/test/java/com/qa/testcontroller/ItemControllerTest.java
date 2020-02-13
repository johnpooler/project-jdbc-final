package com.qa.testcontroller;

//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.qa.controller.*;
//import com.qa.persistence.domain.*;
//import com.qa.services.*;


//@RunWith(MockitoJUnitRunner.class)
//public class ItemControllerTest {
//	
//	@Mock
//	private ItemServices itemServices;
//	
//	/**
//	 * Spy is used because i want to mock some methods inside the item I'm testing
//	 * InjectMocks uses dependency injection to insert the mock into the customer controller
//	 */
//	@Spy
//	@InjectMocks
//	private ItemController itemController;
//
//
//
//	@Test
//	public void readAllTest() {
//		ItemController itemController = new ItemController(itemServices);
//		List<Item> item = new ArrayList<>();
//		item.add(new Item("jesus"));
//		item.add(new Item("Restituto"));
//		item.add(new Item("Nico"));
//		Mockito.when(itemServices.readAll()).thenReturn(item);
//		assertEquals(item, itemController.readAll());
//	}
//	
//	@Test
//	public void createTest() {
//		String name = "Chris";
//		Mockito.doReturn(name).when(customerController).getInput();
//		Customer customer = new Customer(name);
//		Customer savedCustomer = new Customer(1, "Chris");
//		Mockito.when(customerServices.create(customer)).thenReturn(savedCustomer);
//		assertEquals(savedCustomer, customerController.create());
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void updateTest() {
//		String id = "1";
//		String name = "Thompson";
//		Mockito.doReturn(id, name).when(customerController).getInput();
//		Customer customer = new Customer(1, name);
//		Mockito.when(customerServices.update(customer)).thenReturn(customer);
//		assertEquals(customer, customerController.update());
//	}
//	
//
//	/**
//	 * Delete doesn't return anything, so we can just verify that it calls the delete method
//	 */
//	@Test
//	public void deleteTest() {
//		String id = "1";
//		Mockito.doReturn(id).when(customerController).getInput();
//		customerController.delete();
//		Mockito.verify(customerServices, Mockito.times(1)).delete(1);
//	}
//	
//}
	

