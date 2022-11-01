package constructorInheritance;

public class Main {

	public static void main(String[] args) {
		
		Derived_Subclass_Child_Class derived = new Derived_Subclass_Child_Class();
		Derived_Subclass_Child_Class derivedDisplay = new Derived_Subclass_Child_Class(10, 20);
		derivedDisplay.displayVariables();
		
		
		System.out.println("End of program");

	}

}
