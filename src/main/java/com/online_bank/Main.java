package com.online_bank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class git initMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Hibernate configuration
        Configuration config = new Configuration();
        config.addAnnotatedClass(Create_Account.class);
        config.configure(); // Ensure hibernate.cfg.xml is correctly placed
        SessionFactory factory = config.buildSessionFactory();

        while (true) {
            System.out.println("\nWelcome to Online Banking System");
            System.out.println("Please select an option: ");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) { // Validate user input
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // Clear invalid input
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine(); // Consume leftover newline

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

                    // Create a new account object
                    Create_Account newAccount = new Create_Account(name, accountType, bankName, branchName);

                    // Save to database
                    Session session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    session.persist(newAccount);
                    tx.commit();
                    session.close();

                    System.out.println("✅ Account created successfully! Your account number is: " + newAccount.getAccount_number());
                    break;

                case 2:
                    System.out.println("Enter your account number: ");

                    if (!sc.hasNextInt()) { // Validate input
                        System.out.println("❌ Invalid input! Please enter a valid number.");
                        sc.next();
                        continue;
                    }

                    int accountNumber = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    // Open session to fetch account
                    Session viewSession = factory.openSession();
                    Create_Account account = viewSession.get(Create_Account.class, accountNumber);
                    viewSession.close(); // Close session after fetching

                    if (account != null) {
                        System.out.println("\nAccount Details:");
                        System.out.println(account);
                    } else {
                        System.out.println("❌ No account found with account number: " + accountNumber);
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using our service!");
                    factory.close();
                    return; // Exit the program

                default:
                    System.out.println("❌ Invalid option! Please enter a valid choice.\n");
                    break;
            }
        }
    }
}