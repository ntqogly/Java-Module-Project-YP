public class Formatter {
    public static String formatCurrency(double amount) {
        amount = Math.floor(amount * 100) / 100;

        int value = (int) amount;
        String rub;
        if (value % 10 == 1 && value % 100 != 11) {
            rub = "рубль";
        } else if ((value % 10 >= 2 && value % 10 <= 4) && (value % 100 < 10 || value % 100 >= 20)) {
            rub = "рубля";
        } else {
            rub = "рублей";
        }

        return String.format("%.2f %s", amount, rub);
    }
}
