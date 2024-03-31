/**
 * @author <Le Xuan Loc - s3955317>
 */

package org.system.insurance.ui;

import org.system.insurance.manager.ClaimProcessManagerImpl;
import org.system.insurance.model.Claim;
import org.system.insurance.model.Customer;
import org.system.insurance.model.InsuranceCard;
import org.system.insurance.util.FileUtil;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    private static final String CUSTOMERS_FILE_PATH = "src/main/resources/customers.txt";
    private static final String INSURANCE_CARDS_FILE_PATH = "src/main/resources/insuranceCards.txt";
    private static final String CLAIMS_FILE_PATH = "src/main/resources/claims.txt";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static final ClaimProcessManagerImpl claimManager = new ClaimProcessManagerImpl();
    private static List<Customer> customers;
    private static List<InsuranceCard> insuranceCards;
    // No need to keep a separate list of claims; we'll use claimManager instead
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final Scanner scanner = new Scanner(System.in);
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
                    case 3:
                        showClaimDetails();
                        break;
                    case 4:
                        addNewClaim();
                        break;
                    case 5:
                        updateClaim();
                        break;
                    case 6:
                        deleteClaim();
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
        System.out.println("3 - Enter Claims ID");
        System.out.println("4 - Add Claims");
        System.out.println("5 - Update A Claim");
        System.out.println("6 - Delete A Claim");
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
    private static void showClaimDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Claim ID: ");
        String claimId = scanner.nextLine();
        Claim claim = claimManager.getOne(claimId);
        if (claim != null) {
            System.out.println(STR."Claim Details: \{claim}"); // Customize this line to format claim details as you like
        } else {
            System.out.println("Claim not found.");
        }
    }

    private static void addNewClaim() {
        try {
            System.out.println("Enter Claim ID:");
            String id = scanner.nextLine();

            System.out.println("Enter Claim Date (yyyy-MM-dd):");
            Date claimDate = sdf.parse(scanner.nextLine());

            System.out.println("Enter Insured Person ID:");
            String insuredPersonId = scanner.nextLine();

            System.out.println("Enter Card Number:");
            String cardNumber = scanner.nextLine();

            System.out.println("Enter Exam Date (yyyy-MM-dd):");
            Date examDate = sdf.parse(scanner.nextLine());

            System.out.println("Enter Document Names (separated by comma):");
            String docs = scanner.nextLine();
            List<String> documents = List.of(docs.split(","));

            System.out.println("Enter Claim Amount:");
            double claimAmount = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter Status:");
            String status = scanner.nextLine();

            System.out.println("Enter Receiver Banking Info:");
            String receiverBankingInfo = scanner.nextLine();

            Claim claim = new Claim(id, claimDate, insuredPersonId, cardNumber, examDate, documents, claimAmount, status, receiverBankingInfo);
            claimManager.addClaim(claim);

            System.out.println("Claim added successfully.");
        } catch (ParseException e) {
            System.out.println("Error parsing the date. Please try again.");
        } catch (NumberFormatException e) {
            System.out.println("Error parsing the claim amount. Please enter a valid number.");
        }
    }
    private static void updateClaim() {
        try {
            System.out.print("Enter the ID of the claim to update: ");
            String claimId = scanner.nextLine();

            System.out.println("Enter new claim details:");

            System.out.println("Enter Claim Date (yyyy-MM-dd):");
            Date claimDate = sdf.parse(scanner.nextLine());

            System.out.println("Enter Insured Person ID:");
            String insuredPersonId = scanner.nextLine();

            System.out.println("Enter Card Number:");
            String cardNumber = scanner.nextLine();

            System.out.println("Enter Exam Date (yyyy-MM-dd):");
            Date examDate = sdf.parse(scanner.nextLine());

            System.out.println("Enter Document Names (separated by comma):");
            String docs = scanner.nextLine();
            List<String> documents = List.of(docs.split(","));

            System.out.println("Enter Claim Amount:");
            double claimAmount = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter Status:");
            String status = scanner.nextLine();

            System.out.println("Enter Receiver Banking Info:");
            String receiverBankingInfo = scanner.nextLine();

            Claim updatedClaim = new Claim(claimId, claimDate, insuredPersonId, cardNumber, examDate, documents, claimAmount, status, receiverBankingInfo);
            claimManager.updateClaim(claimId, updatedClaim);

            System.out.println("Claim updated successfully.");
        } catch (ParseException e) {
            System.out.println("Error parsing the date. Please try again.");
        } catch (NumberFormatException e) {
            System.out.println("Error parsing the claim amount. Please enter a valid number.");
        }
    }
    private static void deleteClaim() {
        System.out.print("Enter the ID of the claim to delete: ");
        String claimId = scanner.nextLine();

        boolean isDeleted = claimManager.deleteClaim(claimId);
        if (isDeleted) {
            System.out.println("Claim deleted successfully.");
        } else {
            System.out.println("Claim not found.");
        }
    }


    private static void saveDataAndExit() {
        try {
            System.out.println("Saving data...");
            // Assume you've implemented similar methods for customers and insurance cards
            FileUtil.writeClaims(claimManager.getAll(), CLAIMS_FILE_PATH);
            System.out.println("Data saved successfully.");
            System.exit(0);
        } catch (IOException e) {
            System.err.println("Failed to save data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

