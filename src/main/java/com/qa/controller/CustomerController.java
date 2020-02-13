package com.qa.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Customer;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class CustomerController implements CrudController<Customer>{
	
	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);
	
	private CrudServices<Customer> customerService;
	
	public CustomerController(CrudServices<Customer> customerService) {
		this.customerService = customerService;
	}
	
	
	 public String getInput() {
		return Utils.getInput();
	}
	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Customer> readAll() {
		
		List<Customer> customers = customerService.readAll();
		for(Customer customer: customers) {
			LOGGER.info(customer.toString());
		}
		return customers;	
	}
	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Customer create() {

		LOGGER.info("Please enter a first name");
		String name = Utils.getInput();
		
		Customer customer =customerService.create(new Customer( name));
		LOGGER.info("New customer created");
		return customer;
	}
	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Customer update() {
		LOGGER.info("Please enter the id of the customer you would like to update");
		int id = Utils.getIntInput(LOGGER);
		
		LOGGER.info("Please enter a new name");
		String name = Utils.getInput();
		
		Customer customer= customerService.update(new Customer(id, name));
		LOGGER.info("Customer with id "+id+" was updated succesfully");
		return customer;
	}
	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Integer id = Integer.valueOf(Utils.getInput());
		customerService.delete(id);
		LOGGER.info("Customer with id "+id+" was deleted succesfully");
	}

	
}
