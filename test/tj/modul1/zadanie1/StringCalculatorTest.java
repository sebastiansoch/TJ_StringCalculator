package tj.modul1.zadanie1;

import org.junit.Before;
import org.junit.Test;
import sun.awt.windows.WSystemTrayPeer;

import static org.junit.Assert.assertEquals;


public class StringCalculatorTest {
    StringCalculator calculator;

    @Before
    public void createCalculator() {
        calculator = new StringCalculator();
    }

    @Test
    public void shouldReturnZeroWhenEmptyStringGiven() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void shouldReturnNumberWhenNumberGiven() {
        assertEquals(2, calculator.add("2"));
    }

    @Test
    public void shouldSumTwoNumbersWhenTwoNumbersGiven() {
        assertEquals(6, calculator.add("1,5"));
    }

    @Test(expected = NumberFormatException.class)
    public void shouldThrowExceptionWhenNaNGiven() {
        calculator.add("a");
    }

    @Test(expected = NumberFormatException.class)
    public void shouldThrowExceptionWhenDecimalGiven() {
        calculator.add("2.3");
    }


    public static void main(String[] args) {
        
    }
}