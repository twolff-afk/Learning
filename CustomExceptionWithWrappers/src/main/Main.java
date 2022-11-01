package main;

import classes.CustomException;
import classes.MathObject;

public class Main {

	public static void main(String[] args) {
		
		MathObject object = new MathObject(10, 20);
		
		try {
			object.addition();
		} catch (CustomException e) {
			
		}

	}

}
