/**
 * @author <Le Xuan Loc - s3955317>
 */

package org.system.insurance.util;

import org.system.insurance.model.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.system.insurance.model.Claim;
import org.system.insurance.model.Customer;
import org.system.insurance.model.Dependent;
import org.system.insurance.model.InsuranceCard;
import org.system.insurance.model.PolicyHolder;

public class FileUtil {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static List<Customer> readCustomers(String filePath) throws IOException {
        List<Customer> customers = new ArrayList<>();
        List<String> lines = readLines(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            String type = parts[0];
            if ("P".equals(type)) {
                PolicyHolder policyHolder = new PolicyHolder(parts[1], parts[2], null); // Example; adjust as necessary
                customers.add(policyHolder);
            } else if ("D".equals(type)) {
                Dependent dependent = new Dependent(parts[1], parts[2], null); // Example; adjust as necessary
                customers.add(dependent);
            }
        }
        return customers;
    }
    public static List<InsuranceCard> readInsuranceCards(String filePath) throws IOException, ParseException {
        List<InsuranceCard> insuranceCards = new ArrayList<>();
        List<String> lines = readLines(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            // Assuming InsuranceCard constructor: InsuranceCard(String cardNumber, String cardHolderId, Date expirationDate)
            Date expirationDate = dateFormat.parse(parts[3]);
            InsuranceCard card = new InsuranceCard(parts[0], parts[1], expirationDate);
            insuranceCards.add(card);
        }
        return insuranceCards;
    }
    public static List<Claim> readClaims(String filePath) throws IOException, ParseException {
        List<Claim> claims = new ArrayList<>();
        List<String> lines = readLines(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length < 9) { // Expecting at least 9 parts based on your Claim constructor
                System.out.println("Skipping malformed line: " + line);
                continue; // Skip this iteration if not enough parts
            }
            Date claimDate = dateFormat.parse(parts[1]);
            Date examDate = dateFormat.parse(parts[4]);
            List<String> documents = Arrays.asList(parts[5].split(";"));
            double claimAmount = Double.parseDouble(parts[6]);
            String status = parts[7];
            String receiverBankingInfo = parts[8];

            // Assuming your Claim constructor and parts order are correct
            Claim claim = new Claim(parts[0], claimDate, parts[2], parts[3], examDate, documents, claimAmount, status, receiverBankingInfo);
            claims.add(claim);
        }
        return claims;
    }

    // General methods to read and write lines from/to a text file
    private static List<String> readLines(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    public static void writeLines(List<String> lines, String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
    }
}

