package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest {
	
	// you might want this.
	void assertIntEq(int x, int y) {
		assertEquals(x, y);
	}
	
	@Test 
	public void testPut() {
		MapADT<String, String> food = new JavaMap<>(); //strings are case sensitive
		food.put("banana", "fruit");
		food.put("apple", "fruit");
		food.put("carrot", "vegetable");
		food.put("tomato", "vegetable");
		//value will be whatever latest key
		
		assertEquals(food.get("banana"), "fruit");
		assertEquals(food.get("apple"), "fruit");
		assertEquals(food.get("carrot"), "vegetable");
		assertEquals(food.get("tomato"), "vegetable");
	}

	
	@Test 
	public void testRepeatedPut() { //if i repeat the same key, value pair
		MapADT<String, String> food = new JavaMap<>(); //strings are case sensitive
		food.put("banana", "fruit");
		food.put("apple", "fruit");
		food.put("carrot", "vegetable");
		food.put("carrot", "vegetable");
		//value will be whatever latest key
		
		assertEquals(food.get("banana"), "fruit");
		assertEquals(food.get("apple"), "fruit");
		assertEquals(food.get("carrot"), "vegetable");
		assertEquals(food.get("carrot"), "vegetable");
		
	}
	
	@Test 
	public void testChangePut() { //if i change the value of a key 
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
	
	@Test
	public void testEmpty() {
		MapADT<String, String> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
		//Assert.assert
	}
	
	@Test 
	public void testSize1() {
		MapADT<String, String> single = new JavaMap<>();
		single.put("0", "1");
		assertEquals(1, single.size());
		assertEquals(single.size(), 1);
	}
	
	@Test
	public void testSizeInt() {
		MapADT<Integer, Integer> singlenum = new JavaMap <>();
		singlenum.put(7, 17);
		assertEquals(1, singlenum.size());
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
