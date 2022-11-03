package customFinalClass;

// It is not possible to extend a final class
// This would give you an error
public class Robot extends CustomObject {
	
	// final variable
	final int amountLegs = 4;
	// blank final variable, can only initialized within constructor
	final String name;
	
	public Robot(String name) {
		this.name = name;
	}
	
	public void move() {
		
		System.out.println(amountLegs);
		System.out.println(name);
		
		// This would give you a compile time error
		this.amountLegs = 2;
		this.name = "Anna";
		
	}
	
	// arms cannot be changed
	public void calculate(final int arms) {
		
		arms = 10;
		
	}
	
	
	
}
