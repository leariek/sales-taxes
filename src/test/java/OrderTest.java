import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    @BeforeEach
    void setUp(){
        List<String> expected = new ArrayList<String>();
        expected.add("1 music CD at 14.99");
        expected.add("1 chocolate bar at 0.85");
        expected.add("1 imported bottle of perfume at 27.99");
        order = new Order(expected);
    }

    @Test
    void orderAddsProductsCorrect(){
        int size = 3;
        assertEquals(size, order.getOrder().size());
    }

    @Test
    void getAndSetTotalWithoutTaxIsCorrect() {
        Double expected = 14.99;
        order.setTotalWithoutTax(expected);
        assertEquals(expected, order.getTotalWithoutTax());
    }

    @Test
    void getAndSetTotalTaxIsCorrect() {
        Double expected = 7.49;
        order.setTotalTax(expected);
        assertEquals(expected, order.getTotalTax());
    }

    @Test
    void getAndSetTotalWithTaxIsCorrect() {
        Double expected = 52.89;
        order.setTotalWithTax(expected);
        assertEquals(expected, order.getTotalWithTax());
    }
}