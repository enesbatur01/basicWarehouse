import java.util.HashMap;

public class Fields {
    protected String productName;
    protected String producer;
    protected int amount;
    protected String unit;
    protected String shelf;

    public Fields() {
    }

    public Fields(String productName, String producer, int amount, String unit, String shelf) {
        this.productName = productName;
        this.producer = producer;
        this.amount = amount;
        this.unit = unit;
        this.shelf = shelf;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    @Override
    public String toString() {
        return "Fields{" +
                "productName='" + productName + '\'' +
                ", producer='" + producer + '\'' +
                ", amount=" + amount +
                ", unit='" + unit + '\'' +
                ", shelf='" + shelf + '\'' +
                '}';
    }
}
