import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TaxCalculator {

    private static final Double IMPORT_TAX = 0.05;

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
        Double tax = product.getTaxRate();
        if (product.getIsImported()) {
            tax = tax + IMPORT_TAX;
        }
        Double roundedApplicableTax = roundAmount(tax * product.getPrice() * product.getQuantity());
        Double roundedPriceWithTax = roundAmount(roundedApplicableTax + product.getPrice() * product.getQuantity());
        product.setPriceWithTax(roundedPriceWithTax);
        return roundedApplicableTax;
    }

    private Double roundAmount(Double amount){
        int places = 2;
        BigDecimal bigDecimal = BigDecimal.valueOf(amount);
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

}
