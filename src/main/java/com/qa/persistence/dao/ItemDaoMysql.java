package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Item;

public class ItemDaoMysql implements Dao<Item> {
	
	public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class);
	private String jdbcConnectionUrl;
	private String username;
	private String password;
	public ItemDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.189.95.166/projectdb";
		this.username = username;
		this.password = password;
	}
	public ItemDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}
	
	Item itemFromResultSet(ResultSet resultSet) throws SQLException {
		Integer id = resultSet.getInt("id");
		String name = resultSet.getString("name");
		Integer cost= resultSet.getInt("cost");
		return new Item(name, id, cost);
	}
	
	/**
	 * Reads all items from the database with their respective ids and costs
	 * 
	 * @return A list of items
	 */
	@Override
	public List<Item> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement1 = connection.createStatement();
				ResultSet resultSet = statement1.executeQuery("select * from item");) {
			
			
			ArrayList<Item> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(itemFromResultSet(resultSet));
			}
			return items;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
			
			


	
	/**
	 * Creates an item in the database
	 * 
	 * @param customer - takes in an item object. id will be ignored
	 */
	@Override
	public Item create(Item item) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement2 = connection.createStatement();) {
			statement2.executeUpdate("insert into item(name, cost) values('" + item.getName() +"', "+item.getCost()+  ")" );
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	
	/**
	 * Updates an item in the database
	 * 
	 * @param item - takes in an item object, the id field will be used to
	 *                 update that item in the database
	 */
	@Override
	public Item update(Item item) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement3 = connection.createStatement();) {
			statement3.executeUpdate( "UPDATE item SET name ='" + item.getName()+"', cost="+ item.getCost()+" where id ="+item.getId() );
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * Deletes an item from the database
	 * 
	 * @param id - id of the item
	 */
	@Override
	public void delete(int id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement4 = connection.createStatement();) {
			statement4.executeUpdate("delete from item where id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
}
