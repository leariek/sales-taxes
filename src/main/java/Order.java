import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Order {

    private List<Product> order = new ArrayList<Product>();
    private static final List<String> EXEMPT_PRODUCTS = Arrays.asList("book", "chocolates", "pills");

    public Order(List<String> orderContent){
        createOrder(orderContent);
    }

    private void createOrder(List<String> orderContent){
        orderContent.stream().forEach(l -> order.add(addProduct(scanQuantity(l), scanDescription(l), scanPrice(l))));

        }

        private int scanQuantity(String productInfo){
            Pattern p = Pattern.compile("^[\\d+]*");
            Matcher m = p.matcher(productInfo);
            m.find();
            return Integer.parseInt(m.group());
        }

    private String scanDescription(String productInfo){
        Pattern p = Pattern.compile("[a-zA-Z].+(?=\\s\\d)");
        Matcher m = p.matcher(productInfo);
        m.find();
        return m.group();
    }

    private Double scanPrice(String productInfo){
        Pattern p = Pattern.compile("\\d+\\.\\d\\d");
        Matcher m = p.matcher(productInfo);
        m.find();
        return Double.parseDouble(m.group());
    }


    private Product addProduct(int quantity, String description, Double price){
        Product product;
        if(EXEMPT_PRODUCTS.stream().anyMatch(d -> description.contains(d))){
            product = new ExemptTaxProduct(quantity, description, price);
        } else {
            product = new StandardTaxProduct(quantity, description, price);
        }
        order.add(product);
        return product;
    }

    public List<Product> getOrder(){
        return this.order;
    }

}
