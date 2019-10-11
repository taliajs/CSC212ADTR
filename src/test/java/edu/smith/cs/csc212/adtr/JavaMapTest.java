package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest {
	
	// you might want this.
	void assertIntEq(int x, int y) {
		assertEquals(x, y);
	}
	
	/**
	 * Put 
	 */
	@Test
	public void testPutSingle() {
		MapADT<String, String> items = new JavaMap<>();
		items.put("pumpkin", "fall");
		assertEquals(items.get("pumpkin"), "fall");	
	}
	
	@Test 
	public void testPut() {
		MapADT<String, String> food = new JavaMap<>(); //strings are case sensitive
		food.put("banana", "fruit");
		food.put("apple", "fruit");
		food.put("carrot", "vegetable");
		food.put("tomato", "vegetable");
		
		assertEquals(food.get("banana"), "fruit");
		assertEquals(food.get("apple"), "fruit");
		assertEquals(food.get("carrot"), "vegetable");
		assertEquals(food.get("tomato"), "vegetable");
	}

	@Test 
	//If I repeat the same key, value pair
	public void testRepeatedPut() { 
		MapADT<String, String> food = new JavaMap<>(); //strings are case sensitive
		food.put("banana", "fruit");
		food.put("apple", "fruit");
		food.put("carrot", "vegetable");
		food.put("carrot", "vegetable");
		//value will be whatever the latest key is 
		
		assertEquals(food.get("banana"), "fruit");
		assertEquals(food.get("apple"), "fruit");
		assertEquals(food.get("carrot"), "vegetable");
		assertEquals(food.get("carrot"), "vegetable");
	}
	
	@Test 
	//If I change the value of a key 
	public void testChangePut() { 
		MapADT<String, String> food = new JavaMap<>(); //strings are case sensitive
		food.put("banana", "fruit");
		food.put("apple", "fruit");
		food.put("carrot", "vegetable"); 
		food.put("tomato", "fruit"); //changed vegetable to fruit
		
		assertEquals(food.get("banana"), "fruit");
		assertEquals(food.get("apple"), "fruit");
		assertEquals(food.get("carrot"), "vegetable");
		assertEquals(food.get("tomato"), "fruit");
	}
	
	/**
	 * Get
	 */
	@Test 
	public void testNumGetSingle() {
		MapADT<Integer, Integer> singlenumber = new JavaMap<>();
		singlenumber.put(7, 17);
		
		//Solutions: 
		assertIntEq(singlenumber.get(7), 17);
		assertEquals((int) singlenumber.get(7), 17);
		assertEquals(singlenumber.get(7), (Integer) 17);
	}
	
	@Test 
	public void testNumGet() {
		MapADT<Integer, Integer> squares = new JavaMap<>();
		squares.put(1,1);
		squares.put(2,4);
		squares.put(3,9);
		//ambiguous:
		//assertEquals(int,int)
		//asertEquals(Object, Object)
		//assertEquals(squares.get(2),4);
		
		//Solution:
		assertEquals((int) squares.get(2), 4);
		assertEquals(squares.get(2), (Integer) 4);
		assertIntEq(squares.get(2), 4);
	}
	
	/**
	 * Size
	 */
	@Test
	public void testEmpty() {
		MapADT<String, String> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test 
	public void testSize1() {
		MapADT<String, String> single = new JavaMap<>();
		single.put("0", "1");
		assertEquals(1, single.size());
		assertEquals(single.size(), 1);
	}
	
	@Test
	public void testSize4() {
		MapADT<String, String> four = new JavaMap <>();
		four.put("7", "17");
		four.put("4", "44");
		four.put("20", "9");
		four.put("11", "13");
		assertEquals(4, four.size());
	}
	
	@Test
	public void testSizeInt1() {
		MapADT<Integer, Integer> singlenum = new JavaMap <>();
		singlenum.put(7, 17);
		assertEquals(1, singlenum.size());
	}
	
	@Test
	public void testSizeInt() {
		MapADT<Integer, Integer> nums = new JavaMap <>();
		nums.put(7, 17);
		nums.put(10, 13);
		assertEquals(2, nums.size());
	}
	

	
	/**
	 * Remove
	 */
	@Test
	public void testRemoveSingle() {
		MapADT<String, String> list = new JavaMap<>(); 
		list.put("october", "halloween");
		list.remove("october"); //only need to remove the key
		assertEquals(0, list.size());
	}
	
	@Test 
	public void testRemove() {
		MapADT<String, String> list = new JavaMap <>();
		list.put("7", "17");
		list.put("4", "44");
		list.put("20", "9");
		list.put("11", "13");
		list.remove("4"); //only need to remove the key --> will remove the whole row
		assertEquals(3, list.size());
	}

}
