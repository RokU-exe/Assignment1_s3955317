/**
 * @author <Le Xuan Loc - s3955317>
 */

package org.system.insurance.util;

import org.system.insurance.model.Customer;
import org.system.insurance.model.Dependent;
import org.system.insurance.model.PolicyHolder;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    // Existing methods for readInsuranceCards, readClaims, readLines, and writeLines remain the same

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

