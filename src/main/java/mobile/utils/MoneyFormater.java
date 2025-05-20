package mobile.utils;

public class MoneyFormater {

    public static String formatToUSD(String amountStr) {
        double amount = Double.parseDouble(amountStr);
        return String.format("$%.2f", amount);
    }

}
