import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private String description;
    private int quantity;
    private double price;
    private Product product;

    @BeforeEach
    void setUp() {
        quantity = 1;
        description = "bottle of perfume";
        price = 6.99;
        product = new Product(quantity, description, price);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getDescription() {
        assertEquals(description, product.getDescription());
    }

    @Test
    void getPrice() {
        assertEquals(price, product.getPrice());
    }

    @Test
    void getQuantity() {
        assertEquals(quantity, product.getQuantity());
    }

    @Test
    void getIsImported() {
        String importedDescription = "imported music CD";
        Product importedProduct = new Product(quantity, importedDescription, price);

        assertTrue(importedProduct.getIsImported());
        assertFalse(product.getIsImported());
    }

    @Test
    void getIsExempt() {
        String exemptDescription = "box of chocolates";
        Product exemptProduct = new Product(quantity, exemptDescription, price);

        assertTrue(exemptProduct.getIsExempt());
        assertFalse(product.getIsExempt());
    }
}