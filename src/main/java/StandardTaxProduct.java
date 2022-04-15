public class StandardTaxProduct extends Product {

    public StandardTaxProduct(int quantity, String description, Double price) {
        super(quantity, description, price);
        this.setTaxRate(0.1);
    }
}
