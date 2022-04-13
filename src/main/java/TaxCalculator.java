import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TaxCalculator {

    private static final Double IMPORT_TAX = 0.05;
    private static final Double EXEMPT_TAX = 0.0;
    private static final Double STANDARD_TAX = 0.1;

    public TaxCalculator(Order order){
        Double totalWithoutTax = 0.0;
        Double totalTax = 0.0;
        Double totalWithTax = 0.0;

        for(Product product:order.getOrder()){
            totalWithoutTax = totalWithoutTax + (product.getQuantity() * product.getPrice());
            totalTax = totalTax + calculateTax(product);
        }
        totalWithTax = totalWithoutTax + totalTax;
        order.setTotalTax(totalTax);
        order.setTotalWithoutTax(totalWithoutTax);
        order.setTotalWithTax(totalWithTax);
    }

    private Double calculateTax(Product product){
        Double tax = STANDARD_TAX;
        if (product instanceof ExemptTaxProduct){
            tax = EXEMPT_TAX;
        }
        if (product.getIsImported()) {
            tax = tax + IMPORT_TAX;
        }
        Double roundedApplicableTax = roundAmount(tax * product.getPrice() * product.getQuantity());
        product.setPriceWithTax(roundedApplicableTax + product.getPrice() * product.getQuantity());
        return roundedApplicableTax;
    }

    private Double roundAmount(Double amount){
        int places = 2;
        BigDecimal bigDecimal = BigDecimal.valueOf(amount);
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

}
