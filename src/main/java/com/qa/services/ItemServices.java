package com.qa.services;


import java.util.List;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Item;

public class ItemServices implements CrudServices<Item> {

	private Dao<Item> itemDao;
	
	public ItemServices(Dao<Item> itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public List<Item> readAll() {
		
       return itemDao.readAll();
	}

	@Override
	public Item create(Item t) {

		return itemDao.create(t);
	}

	@Override
	public Item update(Item t) {

		return itemDao.update(t);
		
		
	}

	@Override
	public void delete(int id) {

		itemDao.delete(id);
		
	}
	

		
	}




