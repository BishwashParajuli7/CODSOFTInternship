package CodSoftInternship;
import java.util.*;
public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Currency Converter!");
        while (true) {
            System.out.println("Select the base currency:");
            System.out.println("1. USD (United States Dollar)");
            System.out.println("2. EUR (Euro)");
            System.out.println("3. INR (Indian Rupee)");
            System.out.println("4. YEN (Japanese Yen)");
            System.out.println("5. CAD (Canadian Dollar)");
            System.out.println("6. YUAN (Chinese Yuan)");
            System.out.println("0. Exit");
            int baseCurrencyChoice = getChoice(scanner);
            if (baseCurrencyChoice == 0) {
                break;
            }
            int targetCurrencyChoice = getTargetCurrencyChoice(scanner);
            double amount = getAmount(scanner);
            double convertedAmount = convertCurrency(baseCurrencyChoice,
                    targetCurrencyChoice, amount);
            System.out.println("Converted amount: " + convertedAmount);
            System.out.print("Do you want to convert another amount? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                break;
            }
        }
        System.out.println("Thank you for using Currency Converter!");
        scanner.close();
    }
    private static int getChoice(Scanner scanner) {
        int choice;
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= 6) {
                    break;
                }
            } else {
                scanner.next(); // Consume invalid input
            }
            System.out.println("Invalid choice. Please select a valid option.");
        }
        return choice;
    }
    private static int getTargetCurrencyChoice(Scanner scanner) {
        int targetChoice;
        while (true) {
            System.out.println("Select the target currency:");
            System.out.println("1. USD (United States Dollar)");
            System.out.println("2. EUR (Euro)");
            System.out.println("3. INR (Indian Rupee)");
            System.out.println("4. YEN (Japanese Yen)");
            System.out.println("5. CAD (Canadian Dollar)");
            System.out.println("6. YUAN (Chinese Yuan)");
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                targetChoice = scanner.nextInt();
                if (targetChoice >= 1 && targetChoice <= 6) {
                    break;
                }
            } else {
                scanner.next(); // Consume invalid input
            }
            System.out.println("Invalid choice. Please select a valid target currency.");
        }
        return targetChoice;
    }
    private static double getAmount(Scanner scanner) {
        double amount;
        while (true) {
            System.out.print("Enter the amount to convert: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount >= 0) {
                    break;
                }
            } else {
                scanner.next(); // Consume invalid input
            }
            System.out.println("Invalid amount. Please enter a non-negative number.");
        }
        return amount;
    }
    private static double convertCurrency(int baseCurrencyChoice, int
            targetCurrencyChoice, double amount) {
        double conversionRate = 0.0;
        switch (baseCurrencyChoice) {
            case 1: // USD (United States Dollar)
                switch (targetCurrencyChoice) {
                    case 1: // USD to USD
                        conversionRate = 1.0;
                        break;
                    case 2: // USD to EUR
                        conversionRate = 0.95;
                        break;
                    case 3: // USD to INR
                        conversionRate = 83.18;
                        break;
                    case 4: // USD to YEN
                        conversionRate = 149.86;
                        break;
                    case 5: // USD to CAD
                        conversionRate = 1.37;
                        break;
                    case 6: // USD to YUAN
                        conversionRate = 7.32;
                        break;
                }
                break;
            case 2: // EUR (Euro)
                switch (targetCurrencyChoice) {
                    case 1://EUR to USD
                        conversionRate = 1.06;
                        break;
                    case 2://EUR to INR
                        conversionRate = 87.96;
                        break;
                    case 3://EUR to YEN
                        conversionRate = 158.47;
                        break;
                    case 4://EUR to CAD
                        conversionRate = 1.45;
                        break;
                    case 5://EUR to YUAN
                        conversionRate = 7.74;
                        break;
                }
                break;
            case 3: // INR (Indian Rupee)
                switch (targetCurrencyChoice) {
                    case 1://INR to USD
                        conversionRate = 0.012;
                        break;
                    case 2: //INR to EUR
                        conversionRate = 0.011;
                        break;
                    case 3://INR to YEN
                        conversionRate = 1.80;
                        break;
                    case 4://INR to CAD
                        conversionRate = 0.016;
                        break;
                    case 5://INR to YAUN
                        conversionRate = 0.088;
                        break;
                }
                break;
            case 4: // YEN (Japanese Yen)
                switch (targetCurrencyChoice) {
                    case 1://YEN to USD
                        conversionRate = 0.0067;
                        break;
                    case 2://YEN to EUR
                        conversionRate = 0.0063;
                        break;
                    case 3://YEN to INR
                        conversionRate = 0.56;
                        break;
                    case 4://YEN to CAD
                        conversionRate = 0.0092;
                        break;
                    case 5://YEN to YAUN
                        conversionRate = 0.048;
                        break;
                }
                break;
            case 5: // CAD (Canadian Dollar)
                switch (targetCurrencyChoice) {
                    case 1://CAD to USD
                        conversionRate = 0.73;
                        break;
                    case 2://CAD to EUR
                        conversionRate = 0.69;
                        break;
                    case 3://CAD to INR
                        conversionRate = 60.66;
                        break;
                    case 4://CAD to YEN
                        conversionRate = 109.30;
                        break;
                    case 5://CAD to YAUN
                        conversionRate = 5.34;
                        break;
                }
                break;
            case 6: // YUAN (Chinese Yuan)
                switch (targetCurrencyChoice) {
                    case 1://YAUN to USD
                        conversionRate = 0.14;
                        break;
                    case 2://YAUN to EUR
                        conversionRate = 0.13;
                        break;
                    case 3://YAUN to INR
                        conversionRate = 11.37;
                        break;
                    case 4://YAUN to YEN
                        conversionRate = 20.48;
                        break;
                    case 5://YAUN to CAD
                        conversionRate = 0.19;
                        break;
                }
                break;
        }
        return amount * conversionRate;
    }
}
