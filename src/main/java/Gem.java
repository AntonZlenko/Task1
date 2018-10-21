import java.math.BigDecimal;

public class Gem {


    protected String name;
    protected double weight;
    protected int clarity;
    protected BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getClarity() {
        return clarity;
    }

    public void setClarity(int clarity) {
        this.clarity = clarity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

