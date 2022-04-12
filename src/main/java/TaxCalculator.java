import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TaxCalculator {

    private static Double IMPORT_TAX = 0.05;
    private static Double EXEMPT_TAX = 0.0;
    private static Double STANDARD_TAX = 0.1;

    private Double totalWithoutTax = 0.0;
    private Double totalTax = 0.0;
    private Double totalWithTax = 0.0;

    public TaxCalculator(List<Product> products){

        for(Product product:products){
            this.totalWithoutTax = this.totalWithoutTax + (product.getQuantity() * product.getPrice());
            this.totalTax = this.totalTax + calculateTax(product);
        }
        this.totalWithTax = this.totalWithoutTax + this.totalTax;
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
        product.setApplicableTax(roundedApplicableTax);
        return roundedApplicableTax;
    }

    private Double roundAmount(Double amount){
        int places = 2;
        BigDecimal bigDecimal = BigDecimal.valueOf(amount);
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public Double getTotalWithTax() {
        return totalWithTax;
    }
}
