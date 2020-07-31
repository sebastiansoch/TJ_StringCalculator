package tj.modul2.zadanie1;

public class VatService {

    private final double vatValue;

    public VatService() {
        this.vatValue = 0.23;
    }

    public double getGrossPriceForDefaultVat(Product product) throws Exception {
        return getGrossPrice(product.getNetPrice(), vatValue);
    }

    public double getGrossPrice(double netPrice, double vatValue) throws Exception {
        if (vatValue > 1) {
            throw new Exception("Vat value is too big");
        }

        return netPrice * (1 + vatValue);
    }

}
