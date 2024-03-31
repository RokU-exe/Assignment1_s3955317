/**
 * @author <Le Xuan Loc - s3955317>
 */

package org.system.insurance.ui;

import org.system.insurance.manager.ClaimProcessManagerImpl;
import org.system.insurance.model.Customer;
import org.system.insurance.util.FileUtil;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final ClaimProcessManagerImpl claimManager = new ClaimProcessManagerImpl();
    private static List<Customer> customers; // Assuming a global list of customers

    public static void main(String[] args) {
        try {
            // Initialize system with data from files
            customers = FileUtil.readCustomers("src/main/resources/customers.txt");
            // Similar methods for loading insurance cards and claims...
            System.out.println("Insurance Claims Management System Initialized.");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                showMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                switch (choice) {
                    case 1:
                        listAllCustomers();
                        break;
                    case 2:
                        // Placeholder for additional functionalities
                        // For example: addClaim(scanner);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading system data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void showMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1 - List All Customers");
        // Add more options here
        System.out.println("0 - Exit");
        System.out.print("Enter your choice: ");
    }

    private static void listAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    // Placeholder methods for additional functionalities, e.g., adding a claim
    // private static void addClaim(Scanner scanner) {
    //     System.out.println("Adding a new claim...");
    //     // Implement claim addition logic here
    // }
}

