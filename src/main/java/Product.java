public abstract class Product {

    static final String IMPORTED = "imported";

    private String description;
    private Double price;
    private int quantity;
    private Boolean isImported = false;
    private Double taxRate = 0.0;

    private Double priceWithTax = 0.0;

    public Product(int quantity, String description, Double price) {
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        setIsImported(this.description);
    }

    private void setIsImported(String description) {
        if(description.contains(IMPORTED)) {
            this.isImported = true;
        }
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public void setPriceWithTax(Double priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    public String getDescription() {
        return this.description;
    }

    public Double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Boolean getIsImported() {
        return this.isImported;
    }

    public Double getPriceWithTax() { return this.priceWithTax; }

    public Double getTaxRate() {
        return taxRate;
    }
}


