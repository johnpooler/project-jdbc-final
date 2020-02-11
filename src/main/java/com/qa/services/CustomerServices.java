package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Customer;

public class CustomerServices implements CrudServices<Customer> {

	Dao<Customer> customerDao;
	
	public CustomerServices(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> readAll() {
			// TODO Auto-generated method stub
       return customerDao.readAll();
	}

	@Override
	public Customer create(Customer t) {
		// TODO Auto-generated method stub
		return customerDao.create(t);
	}

	@Override
	public void update(Customer t) {
		// TODO Auto-generated method stub
		customerDao.update(t);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		customerDao.delete(id);
		
	}
	

		
	}




