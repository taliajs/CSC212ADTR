package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.sun.tools.javac.util.List;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class ChallengeTest {

	@Test
	public void ChallengeUnion() {
		SetADT<Integer> int1 = new JavaSet<>();
		int1.insert(1);
		int1.insert(2);
		int1.insert(3);

		SetADT<Integer> int2 = new JavaSet<>();
		int2.insert(4);
		int2.insert(5);
		int2.insert(6);

		// result of the method
		SetADT<Integer> Union = Challenges.union(int1, int2);
		Assert.assertEquals(6, Union.size());
		Assert.assertEquals(true, Union.contains(1));
		Assert.assertEquals(true, Union.contains(2));
		Assert.assertEquals(true, Union.contains(3));
		Assert.assertEquals(true, Union.contains(4));
		Assert.assertEquals(true, Union.contains(5));
		Assert.assertEquals(true, Union.contains(6));
	}

	@Test
	public void ChallengeIntersection() {
		SetADT<Integer> int1 = new JavaSet<>();
		int1.insert(1);
		int1.insert(2);
		int1.insert(3);

		SetADT<Integer> int2 = new JavaSet<>();
		int2.insert(1);
		int2.insert(2);
		int2.insert(6);

		SetADT<Integer> intersection = Challenges.intersection(int1, int2);
		Assert.assertEquals(2, intersection.size());
		Assert.assertEquals(true, intersection.contains(1));
		Assert.assertEquals(true, intersection.contains(2));

	}

	@Test
	public void ChallengeWordCount() {
		
		String[] data = {"a", "b", "a", "a", "b", "c", "d"};
		ListADT<String> input = new JavaList<>();
		input.addBack("a");
		input.addBack("b");
		input.addBack("a");
		input.addBack("a");
		input.addBack("b");
		input.addBack("c");
		input.addBack("d");
		
		MapADT<String, Integer> expectedOutput = new JavaMap<>();
		expectedOutput.put("a", 3);
		expectedOutput.put("b", 2);
		expectedOutput.put("c", 1);
		expectedOutput.put("d", 1);
		
		assertEquals(expectedOutput, Challenges.wordCount(input));
	}

}
