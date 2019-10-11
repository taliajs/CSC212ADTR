package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.errors.BadIndexError;
import edu.smith.cs.csc212.adtr.errors.EmptyListError;
import edu.smith.cs.csc212.adtr.real.JavaList;

//Help from TAs, Lab Partner: Isabel
public class JavaListTest {
	
	/**
	 * Make a new empty list.
	 * @return an empty list to be tested.
	 */
	private <T> ListADT<T> makeEmptyList() {
		return new JavaList<>();
	}
	
	/**
	 * Helper method to make a full list.
	 * @return [a, b, c, d] - a small, predictable list for many tests.
	 */
	private ListADT<String> makeFullList() {
		ListADT<String> data = makeEmptyList();
		data.addBack("a");
		data.addBack("b");
		data.addBack("c");
		data.addBack("d");
		return data;
	}
		
	@Test
	public void testEmpty() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(0, data.size());
		Assert.assertEquals(true, data.isEmpty());
	}
	
	
	@Test(expected=EmptyListError.class)
	public void testRemoveFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeFront();
	}
	
	
	@Test(expected=EmptyListError.class)
	public void testRemoveBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeBack();
	}

	@Test(expected=EmptyListError.class)
	public void testRemoveIndexCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeIndex(3);
	}

	@Test
	public void testAddToFront() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addFront("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(0));
		Assert.assertEquals("1", data.getIndex(1));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(2));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-2");
		Assert.assertEquals("-1", data.getIndex(1));
		Assert.assertEquals("-2", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(2));
		Assert.assertEquals("1", data.getIndex(3));
		Assert.assertEquals(false, data.isEmpty());
	}
	
	/**
	 * addtoBack
	 */
	//test list addToBack.
	@Test
	public void testAddToBackEmpty() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addBack("-1");
	}
	
	@Test 
	public void testAddToBackSingle() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(0, data.size());
		data.addBack("-1");
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
	}
	
	@Test
	public void testAddToBack() {
		ListADT<String> data = makeEmptyList();
		data.addBack("-1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addBack("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals(false, data.isEmpty());
		data.addBack("1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(2));
		Assert.assertEquals(false, data.isEmpty());
	}
	
	
	//test list remove
	/**
	 * removeFront
	 */
	@Test 
	public void testRemoveFrontSingle() {
		ListADT<String> data = makeEmptyList(); 
		data.addBack("A");
		data.removeFront();
		Assert.assertEquals(0, data.size()); //A should been removed 
	}
	
	@Test
	public void testRemoveFront() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addBack("a");
		data.addBack("b");
		data.addBack("c");
		data.addBack("d");
		data.removeFront();
		Assert.assertEquals(3, data.size()); //checking the size
		Assert.assertEquals("c", data.getIndex(1)); //the data should have moved up
	}
	
	/**
	 * removeBack
	 */
	@Test
	public void testRemoveBackEmpty() {
		//test empty list
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());	
	}
	
	@Test
	public void testRemoveBackSingle() {
		ListADT<String> data = makeFullList();
		data.removeBack();
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("b", data.getIndex(1));	
	}
	
	/**
	 * removeIndex
	 */
	@Test
	public void testRemoveIndex() {
		ListADT<String> data = makeFullList();
		Assert.assertEquals("c", data.removeIndex(2)); //we removed c
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("d", data.getIndex(2)); // d moves up
	}
	
	/**
	 * addIndex
	 */
	//test addIndex methods.
	@Test 
	public void testAddIndexEnd() {
		ListADT<String> data = makeFullList();
		data.addIndex(4, "e");
		Assert.assertEquals(5, data.size());
		Assert.assertEquals("e", data.getIndex(4));
		Assert.assertEquals("d", data.getIndex(3));
		Assert.assertEquals("c", data.getIndex(2));
		Assert.assertEquals("b", data.getIndex(1));
		Assert.assertEquals("a", data.getIndex(0));
	}
	
	@Test 
	public void testAddIndexBeginning() {
		ListADT<String> data = makeFullList();
		data.addIndex(0, "A");
		Assert.assertEquals(5, data.size());
		Assert.assertEquals("A", data.getIndex(0)); //A should be in the "index position of 0
		Assert.assertEquals("a", data.getIndex(1)); //a (previously at index 0) moves down
	}
	
	@Test
	public void testAddIndexMiddle() {
		ListADT<String> data = makeFullList();
		data.addIndex(2, "C");
		Assert.assertEquals(5, data.size());
		Assert.assertEquals("C", data.getIndex(2));
		Assert.assertEquals("c", data.getIndex(3)); // the data moves down
	}
	
	
	@Test
	public void testGetFront() {
		ListADT<String> data = makeFullList();
		assertEquals("a", data.getFront());
	}
	
	@Test
	public void testGetBack() {
		ListADT<String> data = makeFullList();
		assertEquals("d", data.getBack());
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.getFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.getBack();
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexLow() {
		ListADT<String> data = makeFullList();
		data.getIndex(-2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHigh() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size());
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size()*2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()*2, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHigh() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()+1, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexLow() {
		ListADT<String> data = makeFullList();
		data.addIndex(-1, "the");
	}
	
	// write some tests for setIndex.
	
	/**
	 * setIndex
	 */
	@Test
	public void testSetIndexOne() {
		ListADT<String> data = makeFullList();
		data.setIndex(1, "a");
		Assert.assertEquals(4,  data.size());
		Assert.assertEquals("a", data.getIndex(1)); //index should start at one instead of 0
		Assert.assertEquals("c", data.getIndex(2)); //c replaced b 
		Assert.assertEquals("d", data.getIndex(3)); 
		//there is no value at index 4 
	}
	
	@Test
	public void testSetIndexLow() {
		ListADT<String> data = makeFullList();
		data.addBack("e");
		data.addBack("f");
		data.addBack("g");
		data.addBack("h");
		data.addBack("i");
		data.addBack("j");
		Assert.assertEquals(10, data.size());
		data.setIndex(2, "e"); //set the index for e lower (index was originally at 6)
		Assert.assertEquals(10, data.size()); 
		Assert.assertEquals("e", data.getIndex(2)); //e replaced c, a and b are gone 
		Assert.assertEquals("d", data.getIndex(3)); //index stayed the same
		Assert.assertEquals("e", data.getIndex(4)); 
		Assert.assertEquals("f", data.getIndex(5));
		Assert.assertEquals("i", data.getIndex(8)); 
		Assert.assertEquals("j", data.getIndex(9)); 
		//no values at index 10 or 11; get a BadIndexError Message
	}
	
	
	@Test
	public void testToJava() {
		assertEquals(makeFullList().toJava(), Arrays.asList("a", "b", "c", "d"));
	}
	
	@Test
	public void testEquals() {
		assertEquals(makeFullList(), new JavaList<>(Arrays.asList("a", "b", "c", "d")));
	}
	
	@Test
	public void testEquals2() {
		assertEquals(makeFullList(), makeFullList());
	}
}
