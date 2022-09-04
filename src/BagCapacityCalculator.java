import java.security.KeyPair;
import java.util.Scanner;

public class BagCapacityCalculator {
    private final Scanner scanner = new Scanner(System.in);
    private final Bag bag1;
    private final Bag bag2;
    private final WeightProvider weightProvider = new WeightProvider();

    public BagCapacityCalculator(Bag bag1, Bag bag2) {
        this.bag1 = bag1;
        this.bag2 = bag2;
    }

    public void startFillingBags() {
        while (true) {
            if (areBagsFull()) {
                System.out.println("Все рюкзаки заполнены.");
                System.out.println("Отлично! Вы загрузились по полной и готовы идти в поход!");
                break;
            }

            System.out.println("Что ложим в рюкзак?");
            String itemName = scanner.next();
            if (itemName.equalsIgnoreCase(WeightProvider.FINISH_APP_COMMAND)) {
                showRemainingCapacity();
                break;
            }

            System.out.println("Введите вес предмета " + itemName + ".");
            Double itemWeight = weightProvider.provide();
            if (itemWeight == null) {
                showRemainingCapacity();
                break;
            }

            Item item = new Item(itemName, itemWeight);
            putItemInBag(item);
        }
    }

    private void putItemInBag(Item item) {
        boolean isItemAdded = bag1.addItem(item);
        if (!isItemAdded) {
            System.out.println("В первом рюкзаке не хватает места, пробуем положить второй.");
            isItemAdded = bag2.addItem(item);
            if (!isItemAdded) {
                System.out.println("В втором рюкзаке не хватает места.");
            }
        }
    }

    private void showRemainingCapacity() {
        System.out.println("Оставшееся место в первом рюкзаке: " +
                bag1.getCapacity() + " кг" + "\n" +
                "Оставшееся место во втором рюкзаке: " +
                bag2.getCapacity() + " кг"
        );
    }

    private boolean areBagsFull() {
        return bag1.getCapacity() == 0 && bag2.getCapacity() == 0;
    }
}
