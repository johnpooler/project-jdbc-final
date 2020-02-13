package com.qa.testpersistence;





import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Customer;
public class CustomerTest {
	
	private Customer customer;
	private Customer other;
	
	@Before
	public void setUp() {
		customer = new Customer(1, "Juan");
		other = new Customer(1, "Juan");
	}
	
	@Test
	public void settersTest() {
		assertNotNull(customer.getId());
		assertNotNull(customer.getName());
		
//		customer.setId(null);
//		assertNull(customer.getId());
		customer.setName(null);
		assertNull(customer.getName());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(customer.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customer.equals(new Object()));
	}
	
	@Test
	public void createCustomerWithId() {
		assertEquals(1, customer.getId(), 0);
		assertEquals("Juan", customer.getName());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(customer.equals(customer));
	}
	
	
	@Test
	public void customerNameNullButOtherNameNotNull() {
		customer.setName(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void customerNamesNotEqual() {
		other.setName("goopy");
		assertFalse(customer.equals(other));
	}
	
	
	@Test
	public void otherIdDifferent() {
		other.setId(2);
		assertFalse(customer.equals(other));
	}
	
	
	@Test
	public void constructorWithoutId() {
		Customer customer = new Customer("Jeff");
		assertEquals(0, customer.getId());
		assertNotNull(customer.getName());
	
	}
	
	
	@Test
	public void toStringTest() {
		String toString = "id:1 first name:Juan";
		assertEquals(toString, customer.toString());
	}
}