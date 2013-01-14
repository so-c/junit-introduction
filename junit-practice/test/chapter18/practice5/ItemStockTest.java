package chapter18.practice5;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class ItemStockTest {

	public static class InitialState {
		ItemStock items;

		@Before
		public void setUp() throws Exception {
			items = new ItemStock();
		}
		
		@Test
		public void testGetNum_return_0_when_initial_state() throws Exception {
			Item item = new Item("sample item", 100);
			assertThat(items.getNum(item),is(0));
		}
		
		@Test
		public void testGetNum_return_1_when_added_one_item() throws Exception {
			Item item = new Item("sample item", 100);
			items.add(item);
			
			assertThat(items.getNum(item),is(1));
		}
		
	}
	
	public static class AddedOneItem {
		private ItemStock items;
		private final Item firstItem = new Item("First Item", 100);
		
		@Before
		public void setUp() {
			items = new ItemStock();
			items.add(firstItem);
		}
		
		@Test
		public void testGetNum_return_1() throws Exception {
			assertThat(items.getNum(firstItem),is(1));
		}
		
		@Test
		public void testGetNum_return_2_when_added_twice() throws Exception {
			items.add(firstItem);
			assertThat(items.getNum(firstItem),is(2));
		}
		
		@Test
		public void testGetNum_return_1_when_added_new_item() throws Exception {
			Item secondItem = new Item("Second Item", 2000);
			items.add(secondItem);
			
			assertThat(items.getNum(secondItem),is(1));
		}
		
	}

}
