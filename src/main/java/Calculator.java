import java.util.Scanner;

public class Calculator {
    private int numberOfPeople;
    private Product[] products;
    private int productCount;

    public Calculator(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
        this.products = new Product[10];
        this.productCount = 0;
    }

    public void addProduct(Scanner scanner) {
        System.out.println("Введите название товара:");
        String productName = scanner.next();

        System.out.println("Введите стоимость товара: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Некорректное значение. Повторите ввод:");
            scanner.next();
        }
        double productPrice = scanner.nextDouble();

        if (productCount < products.length) {
            products[productCount++] = new Product(productName, productPrice);
            System.out.println("Товар добавлен: " + productName + " (стоимость: " + Formatter.formatCurrency(productPrice) + ")");
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
}
