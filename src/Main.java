public class Main {
    public static void main(String[] args) {
        System.out.println("Привет!");
        System.out.println("Укажите вместимость для двух рюкзаков (в формате '25.75').");
        System.out.println("Первый рюкзак:");
        WeightProvider weightProvider = new WeightProvider();
        Double bagCapacity = weightProvider.provide();
        if (bagCapacity == null) {
            return;
        }
        Bag bag1 = new Bag(bagCapacity);

        System.out.println("Второй рюкзак:");
        bagCapacity = weightProvider.provide();
        if (bagCapacity == null) {
            return;
        }
        Bag bag2 = new Bag(bagCapacity);

        System.out.println("Начинаем заполнять рюкзаки!");
        BagCapacityCalculator bagCapacityCalculator = new BagCapacityCalculator(bag1, bag2);
        bagCapacityCalculator.startFillingBags();
    }
}
