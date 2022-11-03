import calculator.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddingTest {

    private Calculator calculatorTests;

    @Before
    public void createCalculator() {
        this.calculatorTests = new Calculator();
    }

    @Test
    public void addingTwoIntegers() {

        int result = calculatorTests.add(1, 2);
        Assert.assertEquals(3, result);
    }

    @Test
    public void addingTwoNegativeNumbers() {

        int result = calculatorTests.add(-2, -2);
        Assert.assertEquals(-4, result);
    }

    @After
    public void deleteCalculator() {
        this.calculatorTests = null;
    }

}
