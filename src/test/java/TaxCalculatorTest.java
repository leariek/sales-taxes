import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {

    private TaxCalculator taxCalculator;
    private Order order;

    @BeforeEach
    void setUp() {
        List<String> expected = new ArrayList<String>();
        expected.add("1 imported bottle of perfume at 27.99");
        expected.add("1 bottle of perfume at 18.99");
        expected.add("1 chocolate bar at 0.85");
        order = new Order(expected);
        taxCalculator = new TaxCalculator();

    }

   @Test
    void taxCalculatorIsCorrect(){
        Double totalTax = 6.10;
        Double totalWithoutTax = 47.83;
        Double totalWithTax = 53.93;
        taxCalculator.startCalculation(order);
        assertEquals(totalTax, order.getTotalTax());
        assertEquals(totalWithoutTax, order.getTotalWithoutTax());
        assertEquals(totalWithTax, order.getTotalWithTax());

    }

}