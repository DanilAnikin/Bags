import java.util.Scanner;

public class WeightProvider {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String NUMBER_FORMAT_ERROR_MESSAGE = "Неверный формат ввода, введите дробное число (в формате '25.75').";
    public static final String NEGATIVE_OR_ZERO_ERROR_MESSAGE = "Значение не может отрицательным или равным нулю.";
    public static final String FINISH_APP_COMMAND = "Завершить";

    public Double provide() {
        while (true) {
            double inputDouble;
            String input = scanner.next();
            if (input.equalsIgnoreCase(FINISH_APP_COMMAND)) {
                return null;
            }

            try {
                inputDouble = Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                System.out.println(NUMBER_FORMAT_ERROR_MESSAGE);
                continue;
            }

            if (inputDouble > 0) {
                return inputDouble;
            }
            System.out.println(NEGATIVE_OR_ZERO_ERROR_MESSAGE);
        }
    }
}
