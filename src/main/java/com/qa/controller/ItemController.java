package com.qa.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Item;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

/**
 * Takes in item details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	private CrudServices<Item> itemService;

	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
	}

	/**
	 * Reads all items to the logger
	 */
//	@Override
//	public void readAll() {
//		for (Item item : itemService.readAll()) {
//			LOGGER.info(item.toString());
//		}
//	}
	@Override
	public List<Item> readAll() {
		
		List<Item> items = itemService.readAll();
		for (Item item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	/**
	 * Creates an item by taking in user input
	 */
	@Override
	public Item create() {

		LOGGER.info("Please enter an item name");
		String name = Utils.getInput();
		LOGGER.info("Please enter a cost for your item");
//		double cost = Utils.getIntInput(LOGGER);
//		Double cost = Double.valueOf(getInput());
		Double cost = Double.parseDouble(Utils.getInput());

		Item item = itemService.create(new Item(name, cost));
		LOGGER.info("New item created");
		return item;
	}

	/**
	 * Updates an existing item by taking in user input
	 */
	@Override
	public Item update() {

		LOGGER.info("Please enter the id of the item you would like to update");
		int id = Utils.getIntInput(LOGGER);
		
		LOGGER.info("Please enter a new name");
		String name = Utils.getInput();

		LOGGER.info("Please enter a cost for your item");
		Double cost = Double.parseDouble(Utils.getInput());

		Item item = itemService.update(new Item(name, id, cost));
		LOGGER.info("Item with id " + id + " was updated succesfully");
		return item;
	}

	/**
	 * Deletes an existing item by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Integer id = Integer.valueOf(Utils.getInput());
		itemService.delete(id);
		LOGGER.info("Item with id " + id + " was deleted succesfully");
	}

}
