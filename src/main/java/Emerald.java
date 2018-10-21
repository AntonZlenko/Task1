import java.math.BigDecimal;
import java.math.RoundingMode;


public class Emerald extends Gem{

    private int priceOfCarat = 300;

    public Emerald (double weight, int clarity) {
        this.weight = weight;
        this.clarity = clarity;
    }

    public int getPriceOfCarat() {
        return priceOfCarat;
    }

    public final BigDecimal getPrice() {
        BigDecimal a = new BigDecimal(this.weight);
        BigDecimal b = new BigDecimal(priceOfCarat);
        price = a.multiply(b).setScale(1, RoundingMode.CEILING);
        return price;
    }

    public String toString() {
        return name + "(clarity - " + clarity + "): " + weight + " carat - " + getPrice() + " USD";
    }
}
