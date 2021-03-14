import static org.junit.Assert.*;
import org.junit.Test;

public class DevOpsCalculatorTest {
    private static final double DELTA = 1e-15;
    DevOpsCalculator calculator=new DevOpsCalculator();

    @Test
    public void sqrtTruePositive(){
        assertEquals("Square Root of number for True Positive", 1.0, calculator.sqrt(1), DELTA);
        assertEquals("Square Root of number for True Positive", 4.0, calculator.sqrt(16), DELTA);
        assertEquals("Square Root of number for True Positive", Double.NaN, calculator.sqrt(-1), DELTA);
    }

    @Test
    public void sqrtRootFalsePositive(){
        assertNotEquals("Square Root of number for False Positive", 4.0, calculator.sqrt(25), DELTA);
        assertNotEquals("Square Root of number for False Positive", 5.0, calculator.sqrt(16), DELTA);
        assertNotEquals("Square Root of number for False Positive", 5.0, calculator.sqrt(-25), DELTA);
    }

    @Test
    public void factorialTruePositive(){
        assertEquals("Factorial of number for True positive", Double.NaN,calculator.factorial(-1), DELTA);
        assertEquals("Factorial of number for True positive", Double.NaN,calculator.factorial(2.5), DELTA);
        assertEquals("Factorial of number for True positive", 120.0,calculator.factorial(5), DELTA);
        assertEquals("Factorial of number for True positive", 24.0,calculator.factorial(4), DELTA);
        assertEquals("Factorial of number for True positive",1.0,calculator.factorial(0),DELTA);
    }

    @Test
    public void factorialFalsePositive(){
        assertNotEquals("Factorial of number for False positive", 6.0,calculator.factorial(6), DELTA);
        assertNotEquals("Factorial of number for False positive", 10.0,calculator.factorial(7), DELTA);
    }

    @Test
    public void naturalLogTruePositive(){
        assertEquals("Natural log of number for True positive", 2.833213344056216,calculator.naturalLog(17), DELTA);
        assertEquals("Natural log of number for True positive", 1.791759469228055,calculator.naturalLog(6), DELTA);
        assertEquals("Natural log of number for True positive", Double.NEGATIVE_INFINITY, calculator.naturalLog(0), DELTA);
        assertEquals("Natural log of number for True positive", Double.NaN, calculator.naturalLog(-5), DELTA);
    }

    @Test
    public void naturalLogFalsePositive(){
        assertNotEquals("Natural log of number for False positive", 2.833213344056216,calculator.naturalLog(5), DELTA);
        assertNotEquals("Natural log of number for False positive", 1.791759469228055,calculator.naturalLog(10), DELTA);
        assertNotEquals("Natural log of number for False positive", 0, calculator.naturalLog(0), DELTA);
    }

    @Test
    public void powerTruePositive(){
        assertEquals("Power of number for True positive", 8.0,calculator.power(2, 3), DELTA);
        assertEquals("Power of number for True positive", 9.0,calculator.power(3,2), DELTA);
        assertEquals("Power of number for True positive", 1.0,calculator.power(1,0), DELTA);
        assertEquals("Power of number for True positive", 100.0,calculator.power(100,1), DELTA);
        assertEquals("Power of number for True positive", Double.NaN,calculator.power(3,Double.NaN), DELTA);
    }

    @Test
    public void powerFalsePositive(){
        assertNotEquals("Power of number for False positive", 6.0,calculator.power(2, 3), DELTA);
        assertNotEquals("Power of number for False positive", 8.0,calculator.power(3,2), DELTA);
        assertNotEquals("Power of number for False positive", 0.0,calculator.power(3,0), DELTA);
    }

}
