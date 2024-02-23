import java.util.Scanner;

public class Calculator {
    private int numberOfPeople;
    private Product[] products;
    private int productCount;

    public Calculator(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
        this.products = new Product[10]; //Предполагаю, что товаров будет добавлено макс 10 штук. Можно изменить значение в большую сторону
        this.productCount = 0;
    }

    public void addProduct(Scanner scanner) {
        String inputProductName = "";
        System.out.println("Введите название товара:");

        while (true) {
            inputProductName = scanner.next();

            if (inputProductName.matches(".*\\d.*")) {
                System.out.println("Некорректное наименование. Повторите ввод:");
            } else {
                break;
            }
        }

        double inputProductPrice = 0.0;
        System.out.println("Введите стоимость товара: ");
        while (true) {
            while (!scanner.hasNextDouble()) {
                System.out.println("Некорректное значение. Повторите ввод:");
                scanner.next();
            }
            inputProductPrice = scanner.nextDouble();
            if (inputProductPrice <= 0) {
                System.out.println("Некорректное значение. Повторите ввод:");
            } else {
                break;
            }
        }

        if (productCount < products.length) {
            products[productCount] = new Product(inputProductName, inputProductPrice);
            productCount++;
            System.out.println("Товар добавлен: " + inputProductName + " (стоимость: " + Formatter.formatCurrency(inputProductPrice) + ")");
        }
    }

    public void showProducts() {
        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i].getNameOfProduct() + " (стоимость: " + Formatter.formatCurrency(products[i].getPriceOfProduct()) + ")");
        }
    }

    public void calculateBill() {
        double totalBill = 0.0;
        for (int i = 0; i < productCount; i++) {
            totalBill = totalBill + products[i].getPriceOfProduct();
        }

        double billPerPerson = totalBill / numberOfPeople;

        System.out.println("Сумма на одного человека: " + Formatter.formatCurrency(billPerPerson));
    }

    public boolean addNewProduct(Scanner scanner) {
        System.out.println("Введите: 'Продолжить' для добавления нового товара 'Завершить' для завершения");

        do {
            String inputEndOrContinue = scanner.next().toLowerCase();
            if (inputEndOrContinue.equals("завершить")) {
                return true;
            } else if (inputEndOrContinue.equals("продолжить")) {
                return false;
            } else {
                System.out.println("Некорректный ввод. Введите: 'Продолжить' для добавления нового товара 'Завершить' для завершения");
            }
        } while (true);
    }
}
