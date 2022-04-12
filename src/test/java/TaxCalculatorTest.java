import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {

    private TaxCalculator taxCalculator;
    private Product standardTaxProduct;
    private Product exemptTaxProduct;
    private Product standardImportTaxProduct;


    @BeforeEach
    void setUp() {
        standardTaxProduct = new StandardTaxProduct(1, "music CD", 14.99);
        exemptTaxProduct = new ExemptTaxProduct(1, "chocolate bar", 0.85);
        standardImportTaxProduct = new StandardTaxProduct(1, "imported bottle of perfume", 27.99);
        List<Product> products = new ArrayList<Product>();
        products.add(standardTaxProduct);
        products.add(exemptTaxProduct);
        products.add(standardImportTaxProduct);
        taxCalculator = new TaxCalculator(products);
    }

    @Test
    void getTotalTax() {
        Double expectedTotal = 5.7;
        assertEquals(expectedTotal, taxCalculator.getTotalTax());
    }

    @Test
    void getTotalWithTax() {
        Double expectedTotal = 49.53;
        assertEquals(expectedTotal, taxCalculator.getTotalWithTax());
    }
}