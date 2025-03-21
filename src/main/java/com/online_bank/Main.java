package com.online_bank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Configuration config = new Configuration();
        config.addAnnotatedClass(Create_Account.class);
        config.configure();
        SessionFactory factory = config.buildSessionFactory();

        while (true) {
            System.out.println("\nWelcome to Online Banking System");
            System.out.println("Please select an option: ");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transfer Money");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter your name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter your account type: ");
                    String accountType = sc.nextLine();

                    System.out.println("Enter your bank name: ");
                    String bankName = sc.nextLine();

                    System.out.println("Enter your branch name: ");
                    String branchName = sc.nextLine();

                    Create_Account newAccount = new Create_Account(name, accountType, bankName, branchName, factory);
                    Session session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    session.persist(newAccount);
                    tx.commit();
                    session.close();

                    System.out.println(" Account created successfully!");
                    System.out.println("\nYour account details: ");
                    System.out.println(newAccount);
                    break;

                case 2:
                    System.out.println("Enter your account number: ");
                    String accountNumber = sc.nextLine();

                    Session viewSession = factory.openSession();
                    Create_Account account = viewSession.find(Create_Account.class, accountNumber);
                    viewSession.close();

                    if (account != null) {
                        System.out.println("\n Account Details:");
                        System.out.println(account);
                    } else {
                        System.out.println(" No account found with account number: " + accountNumber);
                    }
                    break;

                case 3:
                    System.out.println("Enter your account number: ");
                    String depositAccountNumber = sc.next();
                    sc.nextLine();

                    Session depositSession = factory.openSession();
                    Create_Account depositAccount = depositSession.get(Create_Account.class, depositAccountNumber);
                    Transaction depositTransaction = depositSession.beginTransaction();

                    if (depositAccount == null) {
                        System.out.println(" No account found with account number: " + depositAccountNumber);
                        depositSession.close();
                        continue;
                    }

                    System.out.println("Enter the amount you would like to deposit: ");
                    double depositAmount = sc.nextDouble();
                    sc.nextLine();

                    depositAccount.setBalance(depositAccount.getBalance() + depositAmount);
                    depositSession.persist(depositAccount);
                    depositTransaction.commit();
                    depositSession.close();

                    System.out.println(" Deposit successful! New balance: " + depositAccount.getBalance());
                    break;

                case 4: // Withdraw Money
                    System.out.println("Enter your account number: ");
                    String withdrawAccountNumber = sc.next();
                    sc.nextLine();

                    Session withdrawSession = factory.openSession();
                    Create_Account withdrawAccount = withdrawSession.find(Create_Account.class, withdrawAccountNumber);
                    Transaction withdrawTransaction = withdrawSession.beginTransaction();

                    if (withdrawAccount == null) {
                        System.out.println(" No account found with account number: " + withdrawAccountNumber);
                        withdrawSession.close();
                        continue;
                    }

                    System.out.println("Enter the amount you want to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    sc.nextLine();

                    if (withdrawAmount > withdrawAccount.getBalance()) {
                        System.out.println(" Insufficient balance! Current balance: " + withdrawAccount.getBalance());
                    } else {
                        withdrawAccount.setBalance(withdrawAccount.getBalance() - withdrawAmount);
                        withdrawSession.persist(withdrawAccount);
                        withdrawTransaction.commit();
                        System.out.println(" Withdrawal successful! New balance: " + withdrawAccount.getBalance());
                    }

                    withdrawSession.close();
                    break;

                case 5: // Transfer Money
                    System.out.println("Enter your account number (Sender): ");
                    String senderAccountNumber = sc.next();
                    sc.nextLine();

                    System.out.println("Enter recipient's account number: ");
                    String receiverAccountNumber = sc.next();
                    sc.nextLine();

                    Session transferSession = factory.openSession();
                    Create_Account senderAccount = transferSession.find(Create_Account.class, senderAccountNumber);
                    Create_Account receiverAccount = transferSession.find(Create_Account.class, receiverAccountNumber);
                    Transaction transferTransaction = transferSession.beginTransaction();

                    if (senderAccount == null) {
                        System.out.println(" Sender account not found.");
                    } else if (receiverAccount == null) {
                        System.out.println(" Recipient account not found.");
                    } else {
                        System.out.println("Enter the amount to transfer: ");
                        double transferAmount = sc.nextDouble();
                        sc.nextLine();

                        if (transferAmount > senderAccount.getBalance()) {
                            System.out.println(" Insufficient balance! Current balance: " + senderAccount.getBalance());
                        } else {
                            senderAccount.setBalance(senderAccount.getBalance() - transferAmount);
                            receiverAccount.setBalance(receiverAccount.getBalance() + transferAmount);
                            transferSession.persist(senderAccount);
                            transferSession.persist(receiverAccount);
                            transferTransaction.commit();
                            System.out.println(" Transfer successful!");
                            System.out.println(" New sender balance: " + senderAccount.getBalance());
                        }
                    }

                    transferSession.close();
                    break;

                case 6:
                    System.out.println(" Thank you for using our service!");
                    factory.close();
                    return;

                default:
                    System.out.println(" Invalid option! Please enter a valid choice.\n");
                    break;
            }
        }
    }
}
