public class Bag {
    private double capacity;
    public double getCapacity(){
        return capacity;
    }
    public boolean addItem(Item item){
        if(item.getWeight() > capacity)
            return true;
        capacity -= item.getWeight();
        return false;
    }
    public Bag(double capacity){
        this.capacity = capacity;
    }
}
