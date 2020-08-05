package tj.modul3.stringcalc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void shouldReturnZeroWhenEmptyStringGiven() {
        //when
        String result = calculator.add("");
        //then
        assertThat(result).isEqualTo("0");
    }

    @Test
    void shouldReturnGivenNumber() {
        //when
        String result = calculator.add("1");
        //then
        assertThat(result).isEqualTo("1.0");
    }

    @Test
    void shouldAddNumbersSeparatedByComma() {
        //when
        String result = calculator.add("1.1,2.2,3,4");
        //then
        assertThat(result).isEqualTo("10.3");
    }

    @Test
    void shouldAddNumbersSeparatedByNewLine() {
        //when
        String result = calculator.add("1\n2,3");
        //then
        assertThat(result).isEqualTo("6.0");
    }

    @Test
    void shouldReturnErrorMessageWhenCommaIsMissing() {
        //when
        String result = calculator.add("175.2,\n35");
        //then
        assertThat(result).isEqualTo("Number expected but '\n' found at position 6.");
    }

    @Test
    void shouldReturnErrorMessageWhenCommaIsLastChar() {
        //when
        String result = calculator.add("1,3,");
        //then
        assertThat(result).isEqualTo("Number expected but EOF found.");
    }

    @Test
    void shouldAddNumbersWhenCustomSeparatorsAreGiven() {
        //when
        //then
        assertThat(calculator.add("//;\n1;2")).isEqualTo("3.0");
        assertThat(calculator.add("//|\n1|2|3")).isEqualTo("6.0");
        assertThat(calculator.add("//sep\n2sep3")).isEqualTo("5.0");
    }

    @Test
    void shouldReturnErrorMessageWhenCustomAndDefaultSeparatorsGiven() {
        //when
        String result = calculator.add("//|\n1|2,3");
        //then
        assertThat(result).isEqualTo("'|' expected but ',' found at position 3.");
    }

    @Test
    void shouldReturnErrorWhenNegativeNumberGiven() {
        //when
        //then
        assertThat(calculator.add("-1,2")).isEqualTo("Negative not allowed : -1.0");
        assertThat(calculator.add("2,-4,-5")).isEqualTo("Negative not allowed : -4.0, -5.0");
    }

}
