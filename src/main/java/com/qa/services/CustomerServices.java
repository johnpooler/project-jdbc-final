package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Customer;

public class CustomerServices implements CrudServices<Customer> {

	private Dao<Customer> customerDao;
	
	public CustomerServices(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> readAll() {
			
       return customerDao.readAll();
	}

	@Override
	public Customer create(Customer customer) {
		
		return customerDao.create(customer);
	}

	@Override
	public Customer update(Customer customer) {
	
		return customerDao.update(customer);
		
	}

	@Override
	public void delete(int id) {
		
		customerDao.delete(id);
		
	}
	

		
	}




