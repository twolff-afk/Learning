package constructorInheritance;

public class Derived_Subclass_Child_Class extends Base_Superclass_Parent_Class {
	
	private int subclassVariable;
	
	Derived_Subclass_Child_Class() {
		System.out.println("Afterwards the subclass constructor");
	}
	
	Derived_Subclass_Child_Class(int constructorParamter1, int constructorParameter2) {
		super(constructorParamter1);
		this.subclassVariable = constructorParameter2;
	}
	
	public void displayVariables() {
		System.out.println("BaseVariable: " + baseVariable + ", SubclassVariable: " + subclassVariable);
	}

}
