package chapter18.practice5;

import java.util.HashMap;
import java.util.Map;

public class ItemStock {
	Map<String, Item> items;
	Map<String, Integer> nums;

	public ItemStock() {
		items = new HashMap<>();
		nums = new HashMap<>();
	}

	public void add(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("item == null");
		}
		
		items.put(item.name, item);

		Integer num = nums.get(item.name);
		if (num == null) {
			num = 1;
		} else {
			num += 1;
		}
		nums.put(item.name, num);
	}

	public int getNum(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("item == null");
		}
		
		Integer num = nums.get(item.name);
		return num == null ? 0 : num;

	}
	
}
