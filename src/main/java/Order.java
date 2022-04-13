import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Order {

    private List<Product> order = new ArrayList<Product>();
    private static final List<String> EXEMPT_PRODUCTS = Arrays.asList("book", "chocolate", "pills");

    private Double totalWithoutTax = 0.0;
    private Double totalTax = 0.0;
    private Double totalWithTax = 0.0;

    public Order(List<String> orderContent){
        orderContent.stream().forEach(l -> addProduct(scanQuantity(l), scanDescription(l), scanPrice(l)));
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

    private int scanQuantity(String productInfo){
        Pattern p = Pattern.compile("^[\\d+]*");
        Matcher m = p.matcher(productInfo);
        m.find();
        return Integer.parseInt(m.group());
    }

    private String scanDescription(String productInfo){
        Pattern p = Pattern.compile("[a-zA-Z].+(?=\\sat\\s\\d)");
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

    public List<Product> getOrder(){
        return this.order;
    }

    public Double getTotalWithoutTax() {
        return totalWithoutTax;
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public Double getTotalWithTax() {
        return totalWithTax;
    }

    public void setTotalWithoutTax(Double totalWithoutTax) {
        this.totalWithoutTax = totalWithoutTax;
    }

    public void setTotalTax(Double totalTax) {
        this.totalTax = totalTax;
    }

    public void setTotalWithTax(Double totalWithTax) {
        this.totalWithTax = totalWithTax;
    }

}
