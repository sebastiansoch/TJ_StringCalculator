package tj.modul2.zadanie1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VatServiceTest {
    VatService vatService;
    Product product;

    @BeforeEach
    void prepareTestParameters() {
        vatService = new VatService();
        product = new Product("111", 120.9);
    }

    @Test
    void shouldCalcGrossPriceForDefaultVat() throws Exception {
        //when
        double result = vatService.getGrossPriceForDefaultVat(product);

        //then
        assertEquals(148.707, result);
    }

    @Test
    void shouldCalcGrossPriceForDefaultVat_AssertJ() throws Exception {
        //when
        double result = vatService.getGrossPriceForDefaultVat(product);

        //then
        Assertions.assertThat(result).isEqualTo(148.707);
    }

    @Test
    void shouldCalcGrossPriceForGivenVat() throws Exception {
        //when
        double result = vatService.getGrossPrice(product.getNetPrice(), 0.10);

        //then
        assertEquals(132.99, result, 3);
    }

    @Test
    void shouldThrowExceptionWhenVatLargerThanOne() {
        //then
        assertThrows(Exception.class, () -> vatService.getGrossPrice(product.getNetPrice(), 2));
    }

    @Test
    void shouldThrowExceptionWhenVatLargerThanOne_AssertJ() {
        //then
        Assertions.assertThatExceptionOfType(Exception.class).isThrownBy(
                () -> vatService.getGrossPrice(product.getNetPrice(), 2));
    }
}
