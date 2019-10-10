package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest {
	
	// size
	// insert
	// contains
	// remove
	
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
		
	}
	
	@Test
	public void testContainsSingle() {
		
	}
	@Test
	public void testContains() {
		SetADT<String> letters = new JavaSet<>();
		letters.insert("T");
		letters.insert("S");
		assertEquals(false, letters.contains("Z"));
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
