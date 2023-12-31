package CodSoftInternship;
import java.util.Scanner;
    class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public String deposit(double amount) {
            this.balance += amount;
            return "Deposit successful. Current balance: " + this.balance;
        }

        public String withdraw(double amount) {
            if (amount <= this.balance) {
                this.balance -= amount;
                return "Withdrawal successful. Current balance: " + this.balance;
            } else {
                return "Insufficient funds. Withdrawal failed.";
            }
        }

        public String checkBalance() {
            return "Current balance: " + this.balance;
        }
    }

    class ATM {
        private BankAccount userAccount;

        public ATM(BankAccount userAccount) {
            this.userAccount = userAccount;
        }

        public void displayMenu() {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                displayMenu();
                System.out.print("Enter choice (1-4): ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character
                        System.out.println(userAccount.withdraw(withdrawAmount));
                        break;

                    case "2":
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character
                        System.out.println(userAccount.deposit(depositAmount));
                        break;

                    case "3":
                        System.out.println(userAccount.checkBalance());
                        break;

                    case "4":
                        System.out.println("Exiting ATM. Thank you!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            }
        }
    }

    public class AtmInterface {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter initial account balance: ");
            double initialBalance = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            BankAccount userAccount = new BankAccount(initialBalance);
            ATM atm = new ATM(userAccount);
            atm.run();
        }
    }

