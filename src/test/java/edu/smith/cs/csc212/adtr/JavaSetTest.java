package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest {
	
	/**
	 * Size
	 */
	@Test
	public void testEmpty() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testSize1() {
		SetADT<String> single = new JavaSet<>();
		single.insert("A");
		//left: expected;
		//right: actual
		assertEquals(1, single.size());
	}
	
	@Test 
	public void testSize() {
		SetADT<String> letters = new JavaSet<>();
		letters.insert("A");
		letters.insert("B");
		letters.insert("C");
		assertEquals(3, letters.size());
		
		}
	
	
	/** 
	 * Insert
	 */
	@Test
	public void testInsertEmpty() {
		SetADT<String> empty = new JavaSet<>();
		// we don't insert anything, so we expect the size to be 0 
		assertEquals(empty.size(), 0);
	}
	
	@Test 
	public void testInsert1() {
		SetADT<String> letters = new JavaSet<>();
		letters.insert("A");
		assertEquals(1, letters.size());
		assertEquals(true, letters.contains("A"));
		assertEquals(false, letters.contains("B"));	
	}
	
	@Test 
	public void testInsert() {
		SetADT<String> letters = new JavaSet<>();
		letters.insert("A");
		letters.insert("B");
		letters.insert("C");
		//inserting 100 times should not change the set
		for (int i=0; i<100; i++) {
			letters.insert("B");
		}
		assertEquals(3, letters.size()); //3 is what the size should be at the end of the test
		assertEquals(true, letters.contains("A"));
		assertEquals(true, letters.contains("B"));
		assertEquals(true, letters.contains("C"));
		//probably makes sense to make a different test for contains 
		assertEquals(false, letters.contains("Z"));
	}
	
	/**
	 * Contains
	 */
	@Test 
	public void testContainsEmpty() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(false, empty.contains(null));
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testContainsSingle() {
		SetADT<String> single = new JavaSet<>();
		single.insert("T");
		assertEquals(true, single.contains("T"));
		assertEquals(1, single.size());	
	}
	
	@Test
	public void testContains() {
		SetADT<String> letters = new JavaSet<>();
		letters.insert("T");
		letters.insert("S");
		assertEquals(true, letters.contains("T"));
		assertEquals(true, letters.contains("S"));
		assertEquals(false, letters.contains("Z"));
	}
	
	/** 
	 * Remove
	 */
	@Test
	public void testRemoveSingle() {
		SetADT<String> single = new JavaSet<>();
		single.insert("K");
		single.remove("K");
		assertEquals(0, single.size());
		assertEquals(false, single.contains("K")); //checking to see if K has been removed
	}
	
	@Test 
	public void testRemove() {
		SetADT<String> letters = new JavaSet<>();
		letters.insert("K");
		letters.insert("M");
		letters.insert("Y");
		letters.remove("Y");
		assertEquals(2, letters.size()); //check the size
		assertEquals(false, letters.contains("Y")); //checking to see if Y has been removed
	}
}
