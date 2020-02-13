package com.qa.testpersistence;


	
	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertFalse;
	import static org.junit.Assert.assertNotNull;
	import static org.junit.Assert.assertNull;
	import static org.junit.Assert.assertTrue;
	import org.junit.Before;
	import org.junit.Test;

	import com.qa.persistence.domain.Item;
	public class ItemTest {
		
		private Item item;
		private Item other;
		
		@Before
		public void setUp() {
			item = new Item("Ludo", 1, 2.99);
			other = new Item("Ludo", 1, 2.99);
		}
		
		@Test
		public void settersTest() {
			assertNotNull(item.getId());
			assertNotNull(item.getName());
			assertNotNull(item.getCost());
			item.setName(null);
			item.setCost(0);
			assertNull(item.getName());
			assertEquals(0, item.getCost(), 0);
			
		}
		
		@Test
		public void equalsWithNull() {
			assertFalse(item.equals(null));
		}
		
		@Test
		public void equalsWithDifferentObject() {
			assertFalse(item.equals(new Object()));
		}
		
		@Test
		public void createCustomerWithId() {
			assertEquals(1, item.getId(), 0);
			assertEquals("Ludo", item.getName());
			assertEquals(2.99, item.getCost(), 0);
		}
		
		@Test
		public void checkEquality() {
			assertTrue(item.equals(item));
		}
		
		
		@Test
		public void customerNameNullButOtherNameNotNull() {
			item.setName(null);
			assertFalse(item.equals(other));
		}
		
		@Test
		public void customerNamesNotEqual() {
			other.setName("goopy");
			assertFalse(item.equals(other));
		}
		
		
		@Test
		public void otherIdDifferent() {
			other.setId(2);
			assertFalse(item.equals(other));
		}
		@Test
		public void otherCostDifferent() {
			other.setCost(69);
			assertFalse(item.equals(other));
		}
	
		
		@Test
		public void constructorWithoutId() {
			Item item = new Item("yoyo", 56);
			assertEquals(0, item.getId());
			assertNotNull(item.getName());
			assertNotNull(item.getCost());
		
		}
		
		
		
		@Test
		public void toStringTest() {
			String toString = "id:1	item name:Ludo          cost:2.99";
			assertEquals(toString, item.toString());
		}
		
}


