package domain;

public class Item {
   private String name;
   private double value;
   private double weight;
   private double media;
   private double  valueWeight;

    public Item(String name, double value, double weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.media = (value+weight)/2;
        this.valueWeight = value/weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double getValueWeight() {
        return valueWeight;
    }

    public void setValueWeight(double valueWeight) {
        this.valueWeight = valueWeight;
    }

    @Override
    public String toString() {
        /*return "Item{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", weight=" + weight +
                ", media=" + media +
                ", valueWeight=" + valueWeight +
                '}';*/
        return String.format("%20s, %12.2f, %12.2f, %12.2f", this.name,
                this.value, this.weight, this.valueWeight);
    }
}
