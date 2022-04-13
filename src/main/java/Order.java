import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {

    private List<Product> order = new ArrayList<Product>();
    private static final List<String> EXEMPT_PRODUCTS = Arrays.asList("book", "chocolates", "pills");

    public Order(List<String> orderContent){
        createOrder(orderContent);
    }

    private void createOrder(List<String> orderContent){
        //orderContent.stream().forEach(l -> );

        }


    public void addProduct(int quantity, String description, Double price){
        Product product;
        if(EXEMPT_PRODUCTS.stream().anyMatch(d -> description.contains(d))){
            product = new ExemptTaxProduct(quantity, description, price);
        } else {
            product = new StandardTaxProduct(quantity, description, price);
        }
        order.add(product);
    }

    public List<Product> getOrder(){
        return this.order;
    }

}
