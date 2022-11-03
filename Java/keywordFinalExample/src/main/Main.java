package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		// Note that final only forbids us from changing the reference the variable holds,
		// it doesn't protect us from changing the internal state of the object it refers to
		
		// final makes the objects reference immutable
		// thus the variable cannot get a new reference to a new object
		// final != immutable
		final List<String> strings = new ArrayList<>();
		if (0 == strings.size()) {
			System.out.println("line: 12 size is 0");
		}
		strings.add("baeldung");
		if (1 == strings.size()) {
			System.out.println("line: 16 size is 1");
		}
		
		final String name = "Anna";
		System.out.println(name);
		
		// String allocates a new memory and therefore newName points to that new memory
		// It is not possible in JAVA to get an address of an object
		String newName = name;
		newName = "Peter";
		System.out.println(newName);
		
		
//		Robot robot = new Robot("Tobi");
//
//		robot.move();
//		robot.calculate(20);
		
	}

}
