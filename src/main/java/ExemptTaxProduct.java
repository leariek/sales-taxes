public class ExemptTaxProduct extends Product {

    public ExemptTaxProduct(int quantity, String description, Double price) {
        super(quantity, description, price);
        this.setTaxRate(0.0);
    }

}
