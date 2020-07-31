package tj.modul2.zadanie2;

public class Product {
    private String id;
    private double netPrice;

    public Product(String id, double netPrice) {
        this.id = id;
        this.netPrice = netPrice;
    }

    public double getNetPrice() {
        return netPrice;
    }
}
