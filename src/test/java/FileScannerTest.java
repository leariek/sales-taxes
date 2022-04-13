import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileScannerTest {

    private FileScanner fileScanner;

    @BeforeEach
    void setUp(){
        fileScanner = new FileScanner();
    }

    @Test
    void scanOrder() {
        String path = "src/test/resources/orderTest.txt";
        List<String> expected = new ArrayList<String>();
        expected.add("1 music CD at 14.99");
        expected.add("1 chocolate bar at 0.85");
        expected.add("1 imported bottle of perfume at 27.99");
        assertEquals(expected, fileScanner.scanOrder(path));


    }
}