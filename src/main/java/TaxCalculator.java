import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {

    private static final Double IMPORT_TAX = 0.05;

    public void startCalculation(Order order){
        Double totalWithoutTax = 0.0;
        Double totalTax = 0.0;
        Double totalWithTax;

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
        Double roundedApplicableTax = roundTaxRate(tax * product.getPrice() * product.getQuantity());
        product.setPriceWithTax(roundedApplicableTax + product.getPrice() * product.getQuantity());
        return roundedApplicableTax;
    }

    private Double roundTaxRate(Double taxRate){
        return Math.ceil(taxRate * 20) / 20;
    }

}
