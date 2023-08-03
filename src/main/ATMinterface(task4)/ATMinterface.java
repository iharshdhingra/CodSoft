package main;


import java.util.Scanner;

//Bank Account class
class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     balance += amount;
     System.out.println("Deposit successful. New balance: $" + balance);
 }

 public boolean withdraw(double amount) {
     if (amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawal successful. New balance: $" + balance);
         return true;
     } else {
         System.out.println("Insufficient funds. Withdrawal unsuccessful.");
         return false;
     }
 }
}

//ATM class
public class ATMinterface {
 private BankAccount bankAccount;
 private Scanner scanner;

 public ATMinterface(double initialBalance) {
     bankAccount = new BankAccount(initialBalance);
     scanner = new Scanner(System.in);
 }

 public void run() {
     while (true) {
         displayOptions();
         int choice = scanner.nextInt();
         scanner.nextLine(); // Consume the newline character

         switch (choice) {
             case 1:
                 checkBalance();
                 break;
             case 2:
                 deposit();
                 break;
             case 3:
                 withdraw();
                 break;
             case 4:
                 System.out.println("Thank you for using our ATM. Goodbye!");
                 return;
             default:
                 System.out.println("Invalid option. Please choose a valid option.");
         }
     }
 }

 private void displayOptions() {
     System.out.println("Welcome to the ATM!");
     System.out.println("1. Check Balance");
     System.out.println("2. Deposit");
     System.out.println("3. Withdraw");
     System.out.println("4. Exit");
     System.out.print("Enter your choice: ");
 }

 private void checkBalance() {
     System.out.println("Your account balance: $" + bankAccount.getBalance());
 }

 private void deposit() {
     System.out.print("Enter the amount to deposit: $");
     double amount = scanner.nextDouble();
     bankAccount.deposit(amount);
 }

 private void withdraw() {
     System.out.print("Enter the amount to withdraw: $");
     double amount = scanner.nextDouble();
     boolean success = bankAccount.withdraw(amount);
     if (!success) {
         System.out.println("Please enter a smaller amount or check your account balance.");
     }
 }

 public static void main(String[] args) {
     double initialBalance = 1000.0; // Initial balance for the bank account
     ATMinterface atm = new ATMinterface(initialBalance);
     atm.run();
 }
}

