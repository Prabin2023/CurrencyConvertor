package currencyConvertor;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    private static Currency usdCurrency;

    public static void main(String[] args) {
        // Initialize currencies
        ArrayList<Currency> currencies = Currency.init();

        // Print default exchange values
        System.out.println("Default Exchange Values:");
        for (Currency currency : currencies) {
            System.out.println(currency.getName() + " (" + currency.getShortName() + "): " + currency.getExchangeValues());
        }

        Scanner scanner = new Scanner(System.in);

        try {
        	System.out.println();
            System.out.print("Enter the value of money to convert: ");
            Double amountToConvert = scanner.nextDouble();

            System.out.print("Which currency you have for exchange? ");
            String initialCurrency = scanner.next();

            System.out.print("In which currency you want to exchange? ");
            String finalCurrency = scanner.next();

            // Find the currency
            for (Currency currency : currencies) {
                if (currency.getShortName().equals(initialCurrency)) {
                    usdCurrency = currency;
                    break;
                }
            }

            // Check if the currency was found
            if (usdCurrency != null) {
                // Get the exchange rate
                Double exchangeRate = usdCurrency.getExchangeValues().get(finalCurrency);

                // Check if the target currency was found
                if (exchangeRate != null) {
                    Double convertedAmount = Currency.convert(amountToConvert, exchangeRate);
                    System.out.println();
                    System.out.println(" The converted amount for " + amountToConvert + " " + initialCurrency + " to " +
                            finalCurrency + " is " + convertedAmount + " " + finalCurrency);
                } else {
                    System.out.println("Exchange rate not found for " + finalCurrency);
                }
            } else {
                System.out.println("Currency not found: " + initialCurrency);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
