import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumberOfPeople;

        while (true) {
            System.out.println("Добрый день. На сколько человек необходимо разделить счет?");

            while (!scanner.hasNextInt()) {
                System.out.println("Необходимо ввести число. Повторите ввод:");
                scanner.next();
            }
            inputNumberOfPeople = scanner.nextInt();

            if (inputNumberOfPeople <= 1) {
                System.out.println("Некорректное значение для подсчета. Повторите ввод");
                scanner.next();
            } else {
                break;
            }
        }

        Calculator calculator = new Calculator(inputNumberOfPeople);
        while (true) {
            calculator.addProduct(scanner);
            if (endingOptions(scanner, calculator)) break;
        }

        System.out.println("Добавленные товары:");
        calculator.showProducts();
        calculator.calculateBill();

    }


    private static boolean endingOptions(Scanner scanner, Calculator calculator) {
        System.out.println("Введите: " +
                "'Продолжить' для добавления нового товара " +
                "'Завершить' для завершения");
        String inputEndOrContinue = scanner.next().toLowerCase();
        if (inputEndOrContinue.equals("завершить")) {
            return true;
        } else if (inputEndOrContinue.equals("продолжить")) {
            calculator.addProduct(scanner);
        }
        return false;
    }
}