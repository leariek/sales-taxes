import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private String description;
    private int quantity;
    private double price;
    private Product product;
    private Double applicableTax;

    @BeforeEach
    void setUp() {
        quantity = 1;
        description = "bottle of perfume";
        price = 6.99;
        product = new StandardTaxProduct(quantity, description, price);
    }

    @Test
    void setApplicableTax(){
        Double setApplicableTax = 1.50;
        product.setPriceWithTax(setApplicableTax);
        assertEquals(setApplicableTax, product.getPriceWithTax());
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
        Product importedProduct = new StandardTaxProduct(quantity, importedDescription, price);

        assertTrue(importedProduct.getIsImported());
        assertFalse(product.getIsImported());
    }

    @Test
    void setAndGetTaxRate() {
        Double expectedTaxRate = 0.2;
        product.setTaxRate(expectedTaxRate);
        assertEquals(expectedTaxRate, product.getTaxRate());
    }

    @Test
    void setAndGetPriceWithTaxRate() {
        Double expectedPriceWithTax = 21.89;
        product.setPriceWithTax(expectedPriceWithTax);
        assertEquals(expectedPriceWithTax, product.getPriceWithTax());
    }

}