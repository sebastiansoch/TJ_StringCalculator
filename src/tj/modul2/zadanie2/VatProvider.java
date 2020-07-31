package tj.modul2.zadanie2;

public interface VatProvider {
    double getDefaultVat();
    double getVatForType(String type);
}
