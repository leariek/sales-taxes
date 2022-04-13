import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {

    private Receipt receipt;

    @BeforeEach
    void setUp() {
        List<String> expected = new ArrayList<String>();
        expected.add("1 music CD at 14.99");
        expected.add("1 chocolate bar at 0.85");
        expected.add("1 imported bottle of perfume at 27.99");
        Order order = new Order(expected);
        receipt = new Receipt();
    }


}