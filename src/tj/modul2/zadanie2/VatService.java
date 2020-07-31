package tj.modul2.zadanie2;

public class VatService {

    private VatProvider vatProvider;

    public VatService(VatProvider vatProvider) {
        this.vatProvider = vatProvider;
    }

    public double getGrossPriceForDefaultVat(Product product) throws Exception {
        return getGrossPrice(product.getNetPrice(), vatProvider.getDefaultVat());
    }

    public double getGrossPriceForType(double netPrice, String type) throws Exception {
        return getGrossPrice(netPrice, vatProvider.getVatForType(type));
    }

    public double getGrossPrice(double netPrice, double vatValue) throws Exception {
        if (vatValue > 1) {
            throw new Exception("Vat value is too big");
        }

        return netPrice * (1 + vatValue);
    }
}
