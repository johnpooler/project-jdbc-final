package com.qa.testservices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Customer;
import com.qa.persistence.domain.Item;
import com.qa.services.CustomerServices;
import com.qa.services.ItemServices;

@RunWith(MockitoJUnitRunner.class)
public class ItemServicesTest {
	
	@Mock
	private Dao<Item> ItemDao;
	
	@InjectMocks
	private ItemServices itemServices;
	
	@Test
	public void itemServicesCreate() {
		Item item = new Item("Risk", 5, 6.89);
		itemServices.create(item);
		Mockito.verify(ItemDao, Mockito.times(1)).create(item);
	}
	
	@Test
	public void customerServicesRead() {
		itemServices.readAll();
		Mockito.verify(ItemDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void itemServicesUpdate() {
		Item item = new Item("Risk", 5, 6.89);
		itemServices.update(item);
		Mockito.verify(ItemDao, Mockito.times(1)).update(item);
	}
	
	@Test
	public void customerServicesDelete() {
		itemServices.delete(1);;
		Mockito.verify(ItemDao, Mockito.times(1)).delete(1);
	}

}
