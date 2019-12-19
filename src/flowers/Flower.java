package flowers;

public class Flower implements Comparable<Flower>{
    private String name;
    private int freshness;
    private int price;
    private int lengthOfTheStem;

public Flower(String name, int freshness, int price, int lengthOfTheStem){
    this.name = name;
    this.freshness = freshness;
    this.price = price;
    this.lengthOfTheStem = lengthOfTheStem;
}
    public String getName() {
        return name;
    }

    public int getFreshness() {
        return freshness;
    }

    public int getPrice() {
        return price;
    }

    public int getLengthOfTheStem() {
        return lengthOfTheStem;
    }

    @Override
    public int compareTo(Flower o) {
        return this.getFreshness()-o.getFreshness();
    }
}
