package chapter19.practice5;

public class ConsumptionTax {
    private final int taxRate;

    public ConsumptionTax(int taxRate) {
        this.taxRate = taxRate;
    }

    public int apply(int rawPrice) {
        int result = rawPrice;
        result += Math.floor((rawPrice * this.taxRate) / 100);
        return result;
    }
    
}
