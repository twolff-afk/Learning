package constructorInheritance;

public class Base_Superclass_Parent_Class {
	
	protected int baseVariable;
	
	public Base_Superclass_Parent_Class() {
		System.out.println("At first the superclass constructor is called");
		System.out.println("Even if the superclass constructor is not called directly");
	}
	
	public Base_Superclass_Parent_Class(int ConstructorParameter) {
		this.baseVariable = ConstructorParameter;
	}
	
}
