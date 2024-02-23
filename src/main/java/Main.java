import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumberOfPeople;

        System.out.println("Добрый день. На сколько человек необходимо разделить счет?");


        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Необходимо ввести число. Повторите ввод:");
                scanner.next();
            }
            inputNumberOfPeople = scanner.nextInt();

            if (inputNumberOfPeople == 1) {
                System.out.println("Некорректное значение для подсчета. Повторите ввод:");
            } else if (inputNumberOfPeople < 1) {
                System.out.println("Некорректное значение для подсчета. Повторите ввод:");
            } else {
                break;
            }
        }

        Calculator calculator = new Calculator(inputNumberOfPeople);
        do {
            calculator.addProduct(scanner);
        } while (!calculator.addNewProduct(scanner));

        System.out.println("Добавленные товары:");
        calculator.showProducts();
        calculator.calculateBill();

    }

}