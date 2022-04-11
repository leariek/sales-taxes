import java.util.Arrays;
import java.util.List;

public class Product {

    private static final List<String> EXEMPT_PRODUCTS = Arrays.asList("book","chocolates","pills" );

    private String description;
    private Double price;
    private int quantity;
    private Boolean isImported = false;
    private Boolean isExempt = false;

    public Product(int quantity, String description, Double price) {
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        defineType(description);
    }

    private void defineType(String description) {
        if(EXEMPT_PRODUCTS.stream().anyMatch(d -> description.contains(d))) {
            this.isExempt = true;
        }
        if(description.contains("imported")) {
            this.isImported = true;
        }
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

    public Boolean getIsExempt() {
        return this.isExempt;
    }

}


