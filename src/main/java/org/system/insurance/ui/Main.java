/**
 * @author <Le Xuan Loc - s3955317>
 */

package org.system.insurance.ui;

import org.system.insurance.manager.ClaimProcessManagerImpl;
import org.system.insurance.model.*;
import org.system.insurance.util.FileUtil;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static final String CUSTOMERS_FILE_PATH = "src/main/resources/customers.txt";
    private static final String INSURANCE_CARDS_FILE_PATH = "src/main/resources/insuranceCards.txt";
    private static final String CLAIMS_FILE_PATH = "src/main/resources/claims.txt";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static final ClaimProcessManagerImpl claimManager = new ClaimProcessManagerImpl();
    private static List<Customer> customers;
    private static List<InsuranceCard> insuranceCards;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            customers = FileUtil.readCustomers(CUSTOMERS_FILE_PATH);
            insuranceCards = FileUtil.readInsuranceCards(INSURANCE_CARDS_FILE_PATH);
            List<Claim> claims = FileUtil.readClaims(CLAIMS_FILE_PATH);
            claims.forEach(claimManager::addClaim);

            associateInsuranceCardsWithCustomers();

            System.out.println("Insurance Claims Management System Initialized.");

            while (true) {
                showMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
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
                        return; // exit main
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error initializing system: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void associateInsuranceCardsWithCustomers() {
        Map<String, InsuranceCard> cardMap = new HashMap<>();
        for (InsuranceCard card : insuranceCards) {
            cardMap.put(card.getCardNumber(), card);
        }
        for (Customer customer : customers) {
            InsuranceCard card = cardMap.get(customer.getInsuranceCardId());
            if (card != null) {
                customer.setInsuranceCard(card);
            }
        }
    }
    //The UI when starting the program
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

    //Add listAllCustomers method
    private static void listAllCustomers() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer customer : customers) {
                System.out.println("PolicyHolder: { ID: " + customer.getId() + ", Name: " + customer.getFullName() + " }");

                InsuranceCard card = customer.getInsuranceCard();
                if (card != null) {
                    System.out.println("\tInsurance Card: { Number: " + card.getCardNumber() + ", Expiration Date: " + sdf.format(card.getExpirationDate()) + " }");
                } else {
                    System.out.println("\tInsurance Card: Not Available");
                }
            }
        }
    }

    //Add listAllClaims method
    private static void listAllClaims() {
        List<Claim> allClaims = claimManager.getAll();
        if (allClaims.isEmpty()) {
            System.out.println("No claims found.");
        } else {
            allClaims.forEach(claim -> System.out.println(STR."Claim ID: \{claim.getId()}, Claim Date: \{sdf.format(claim.getClaimDate())}, Amount: \{claim.getClaimAmount()}, Status: \{claim.getStatus()}"));
        }
    }
    //Add showClaimDetails method
    private static void showClaimDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Claim ID: ");
        String claimId = scanner.nextLine();
        Claim claim = claimManager.getOne(claimId);
        if (claim != null) {
            System.out.println(STR."Claim Details: \{claim}");
        } else {
            System.out.println("Claim not found.");
        }
    }
    //Add addNewClaim method
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
    //Add updateClaim method
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
    //Add deleteClaim method
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

    //Save and update data
    private static void saveDataAndExit() {
        try {
            System.out.println("Saving data...");
            FileUtil.writeClaims(claimManager.getAll(), CLAIMS_FILE_PATH);
            System.out.println("Data saved successfully.");
            System.exit(0);
        } catch (IOException e) {
            System.err.println(STR."Failed to save data: \{e.getMessage()}");
            e.printStackTrace();
        }
    }
}

