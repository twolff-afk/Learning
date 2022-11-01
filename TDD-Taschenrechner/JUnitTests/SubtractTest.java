import calculator.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubtractTest {

    private Calculator calculatorTests;

    @Before
    public void createCalculator() {
        this.calculatorTests = new Calculator();
    }

    @Test
    public void subtractTwoPositiveNumbers() {

        int result = calculatorTests.subtract(6, 2);
        Assert.assertEquals(4, result);
    }

    @After
    public void deleteCalculator() {
        this.calculatorTests = null;
    }

}
