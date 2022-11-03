package classes;

public class MathObject {
	
	private int summand1;
	private int summand2;
	
	public MathObject(int zahl, int zahl2) {
		this.summand1 = zahl;
		this.summand2 = zahl2;
	}
	
	public int addition() throws CustomException {
		
		int result = 0;
		
		try {
			result = summand1 + summand2;
		} catch (ArithmeticException e) {
			throw new CustomException(e.getMessage());
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		} 
		
		return result;
	}
	
}
