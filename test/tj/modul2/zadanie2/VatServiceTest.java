package tj.modul2.zadanie2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class VatServiceTest {
    VatProvider vatProvider;
    VatService vatService;
    Product product;

    @BeforeEach
    void prepareTestParams() {
        vatProvider = mock(VatProvider.class);
        vatService = new VatService(vatProvider);
        product = new Product(UUID.randomUUID().toString(), 120.9);
    }


    @Test
    @DisplayName("Should calculate gross price for default vat")
    void shouldCalcGrossPriceForDefaultVat() throws Exception {
        //given
        when(vatProvider.getDefaultVat()).thenReturn(0.23);

        //when
        double result = vatService.getGrossPriceForDefaultVat(product);

        //then
        assertThat(result).isEqualTo(148.707);
    }

    @Test
    @DisplayName("Should calc gross price for given vat")
    void shouldCalcGrossPriceForGivenVat() throws Exception {
        //when
        double result = vatService.getGrossPrice(product.getNetPrice(), 0.10);

        //then
        assertThat(result).isEqualTo(132.99);
    }

    @Test
    @DisplayName("Should calc gross price for given product type")
    void shouldCalcGrossPriceForGivenType() throws Exception {
        //given
        String food = "Food";
        when(vatProvider.getVatForType(food)).thenReturn(0.10);

        //when
        double result = vatService.getGrossPriceForType(product.getNetPrice(), food);

        //then
        assertThat(result).isEqualTo(132.99);
    }

    @Test
    @DisplayName("Should throw exception when Vat larger than one")
    void shouldThrowExceptionWhenVatLargerThanOne() {
        //then
        assertThatExceptionOfType(Exception.class).isThrownBy(
                () -> vatService.getGrossPrice(product.getNetPrice(), 2)
        );
    }
}