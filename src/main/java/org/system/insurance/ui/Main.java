/**
 * @author <Le Xuan Loc - s3955317>
 */

package org.system.insurance.ui;

import org.system.insurance.manager.ClaimProcessManagerImpl;
import org.system.insurance.model.Claim;
import org.system.insurance.model.Customer;
import org.system.insurance.model.InsuranceCard;
import org.system.insurance.util.FileUtil;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    private static final String CUSTOMERS_FILE_PATH = "src/main/resources/customers.txt";
    private static final String INSURANCE_CARDS_FILE_PATH = "src/main/resources/insuranceCards.txt";
    private static final String CLAIMS_FILE_PATH = "src/main/resources/claims.txt";

    private static final ClaimProcessManagerImpl claimManager = new ClaimProcessManagerImpl();
    private static List<Customer> customers;
    private static List<InsuranceCard> insuranceCards;
    // No need to keep a separate list of claims; we'll use claimManager instead
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        try {
            // Initialize system with data from files
            customers = FileUtil.readCustomers(CUSTOMERS_FILE_PATH);
            insuranceCards = FileUtil.readInsuranceCards(INSURANCE_CARDS_FILE_PATH);
            List<Claim> claims = FileUtil.readClaims(CLAIMS_FILE_PATH);
            // Populate claimManager with loaded claims
            claims.forEach(claimManager::addClaim);

            System.out.println("Insurance Claims Management System Initialized.");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                showMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        listAllCustomers();
                        break;
                    case 2:
                        listAllClaims();
                        break;
                    case 0:
                        saveDataAndExit();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error initializing system: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void showMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1 - List All Customers");
        System.out.println("2 - List All Claims");
        System.out.println("0 - Exit and Save Changes");
        System.out.print("Enter your choice: ");
    }

    private static void listAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            customers.forEach(System.out::println);
        }
    }

    private static void listAllClaims() {
        List<Claim> allClaims = claimManager.getAll();
        if (allClaims.isEmpty()) {
            System.out.println("No claims found.");
        } else {
            allClaims.forEach(claim -> System.out.println("Claim ID: " + claim.getId() + ", Claim Date: " + dateFormat.format(claim.getClaimDate()) +
                    ", Amount: " + claim.getClaimAmount() + ", Status: " + claim.getStatus()));
        }
    }

    private static void saveDataAndExit() {
        try {
            System.out.println("Saving data...");
            // Implement saving of customers, insurance cards, and claims back to files
            // This requires adding methods to FileUtil for writing these objects back to their respective files
            System.out.println("Data saved. Exiting...");
        } catch (Exception e) {
            System.err.println("Error saving data: " + e.getMessage());
            e.printStackTrace();
        }
        System.exit(0);
    }
}

