import java.util.ArrayList;
import java.util.List;

public class Receipt {

    public static void main(String[] args){
        String[] shoppingBaskets = {"src/main/resources/order1.txt", "src/main/resources/order2.txt", "src/main/resources/order3.txt"};

        FileScanner scanner = new FileScanner();

        for(String shoppingBasket : shoppingBaskets){
            List<String> orderInLines = scanner.scanOrder(shoppingBasket);
            Order order = new Order(orderInLines);
            TaxCalculator calculator = new TaxCalculator(order);
            order.getOrder().stream().forEach(o -> System.out.println(o.getQuantity() + " " + o.getDescription() + ": " + o.getPriceWithTax()));
            System.out.println("Sales Taxes: " + order.getTotalTax());
            System.out.println("Total: " + order.getTotalWithTax());
            System.out.println();
        }


    }

}
