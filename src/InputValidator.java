import java.util.Scanner;

public class InputValidator {
    private static final Scanner scanner = new Scanner(System.in);
    public final static String numberFormatErrorMessage = "Неверный формат ввода, введите дробное число (в формате '25.75').";
    public final static String negativeOrZeroErrorMessage = "Значение не может отрицательным или равным нулю.";
    public static double inputCorrectPositiveDouble() {
        while (true) {
            double inputDouble;
            String input = scanner.next();
            try {
                inputDouble = Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                System.out.println(numberFormatErrorMessage);
                continue;
            }
            if (inputDouble > 0)
                return inputDouble;

            System.out.println(negativeOrZeroErrorMessage);
        }
    }
}
