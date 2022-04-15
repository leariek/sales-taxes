import java.text.DecimalFormat;
import java.util.List;

public class Receipt {

    public static void main(String[] args){
        String[] shoppingBaskets = {"src/main/resources/order1.txt", "src/main/resources/order2.txt", "src/main/resources/order3.txt"};

        FileScanner scanner = new FileScanner();
        TaxCalculator taxCalculator = new TaxCalculator();
        DecimalFormat df = new DecimalFormat("#,##0.00");

        for(String shoppingBasket : shoppingBaskets){
            List<String> orderInLines = scanner.scanOrder(shoppingBasket);
            Order order = new Order(orderInLines);
            taxCalculator.startCalculation(order);
            order.getOrder().stream().forEach(o -> System.out.println(o.getQuantity() + " " + o.getDescription() + ": " + df.format(o.getPriceWithTax())));
            System.out.println("Sales Taxes: " + df.format(order.getTotalTax()));
            System.out.println("Total: " + df.format(order.getTotalWithTax()));
            System.out.println();
        }
    }

}
