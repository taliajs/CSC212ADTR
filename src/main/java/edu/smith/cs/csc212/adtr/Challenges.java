package edu.smith.cs.csc212.adtr;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

//Help from: TAs

public class Challenges {

	// The union of two sets is the set of elements that either contains.
	public static SetADT<Integer> union(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();

		// for loop to go over all the elements in left list, then insert in the output
		for (Integer i : left) {
			output.insert(i);
		}

		for (Integer i : right) {
			output.insert(i);
		}
		return output;

	}

	// The intersection of two sets is the set of elements that both contain.
	public static SetADT<Integer> intersection(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();

		for (Integer i : left) {
			if (right.contains(i)) {
				output.insert(i); // output is the intersection
			}
		}
		return output;
	}

	// Count the words in the input list and put them in the map.
	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		MapADT<String, Integer> output = new JavaMap<>();
		
		for (String s : words ) {
			if (output.get(s) == null) {
				output.put(s, 1); //add one 
			} else { 
				output.put(s, output.get(s) + 1); //update the count
			}
		}		
		return output;
		
	}
}
