public class Bag {
    private double capacity;

    public Bag(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public boolean addItem(Item item) {
        if (item.getWeight() > capacity) {
            return false;
        }
        capacity -= item.getWeight();
        return true;
    }
}
