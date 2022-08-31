public class Item {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    private double weight;
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }

    public Item(String name, double weight){
        this.name = name;
        this.weight = weight;
    }
}
