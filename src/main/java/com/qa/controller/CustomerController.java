package com.qa.controller;

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
	
	
	/**
	 * Reads all customers to the logger
	 */
	@Override
	public void readAll() {
		for(Customer customer: customerService.readAll()) {
			LOGGER.info(customer.toString());
		}
	}
	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public void create() {
//		LOGGER.info("Please enter a valid id");
//		int id = Utils.getIntInput(LOGGER);
		LOGGER.info("Please enter a first name");
		String name = Utils.getInput();
		
		customerService.create(new Customer( name));
		LOGGER.info("New customer created");
	}
	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public void update() {
		LOGGER.info("Please enter the id of the customer you would like to update");
		int id = Utils.getIntInput(LOGGER);
//		Integer id = Integer.valueOf(Utils.getInput());
		LOGGER.info("Please enter a new first name");
		String name = Utils.getInput();
		customerService.update(new Customer(id, name));
		LOGGER.info("Customer with id "+id+" was updated succesfully");
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
