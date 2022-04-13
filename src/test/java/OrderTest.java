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
    void getOrder() {
        List<Product> expectedOrder = new ArrayList<Product>();
        Product product = new StandardTaxProduct(1, "test", 6.99);
        expectedOrder.add(product);
        assertEquals(expectedOrder.getClass(), order.getOrder().getClass());
    }
}