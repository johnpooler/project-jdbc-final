package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.qa.persistence.domain.Customer;


public class CustomerDaoMysql implements Dao<Customer> {
	public static final Logger LOGGER = Logger.getLogger(CustomerDaoMysql.class);
	private String jdbcConnectionUrl;
	private String username;
	private String password;
	public CustomerDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.189.95.166/projectdb";
		this.username = username;
		this.password = password;
	}
	public CustomerDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}
	List<Customer> customerResultSetToList(ResultSet resultSet) throws SQLException {
		ArrayList<Customer> customers = new ArrayList<>();
		while (resultSet.next()) {
			Integer id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			Customer customer = new Customer(id, name);
			customers.add(customer);
		}
		return customers;
	}
	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	@Override
	public List<Customer> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from customer");) {
			return customerResultSetToList(resultSet);
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
//	public Customer readLatest() {
//		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//				Statement statement = connection.createStatement();
//				ResultSet resultSet = statement.executeQuery("SELECT FROM customer ORDER BY id DESC LIMIT 1");) {
//			resultSet.next();
//			Integer id = resultSet.getInt("id");
//			String name = resultSet.getString("name");
//			Customer customer = new Customer(id, name);
//			return customer;
//		} catch (Exception e) {
//			LOGGER.debug(e.getStackTrace());
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}
	/**
	 * Creates a customer in the database
	 * 
	 * @param customer - takes in a customer object. id will be ignored
	 */
	@Override
	public Customer create(Customer customer) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into customer(name) values('" + customer.getName() +"')" );
			//return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	/**
	 * Updates a customer in the database
	 * 
	 * @param customer - takes in a customer object, the id field will be used to
	 *                 update that customer in the database
	 */
	@Override
	public void update(Customer customer) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update customer set name ='" + customer.getName() + "' where id =" + customer.getId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	/**
	 * Deletes a customer in the database
	 * 
	 * @param id - id of the customer
	 */
	@Override
	public void delete(int id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from customer where id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
}
