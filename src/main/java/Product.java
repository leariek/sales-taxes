import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public abstract class Product {

    static final String IMPORTED = "imported";

    private String description;
    private Double price;
    private int quantity;
    private Boolean isImported = false;
    private Double taxRate = 0.0;
    private Double applicableTax = 0.0;

    public Product(int quantity, String description, Double price) {
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        defineType(this.description);
    }

    private void defineType(String description) {
        if(description.contains(IMPORTED)) {
            this.isImported = true;
        }
    }

    public void setApplicableTax(Double applicableTax) {
        this.applicableTax = applicableTax;
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

    public Double getApplicableTax() { return this.applicableTax; }

}


