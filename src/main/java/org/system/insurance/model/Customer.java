package org.system.insurance.model;

/**
 * Abstract class representing a generic customer in the insurance system.
 * This class will be extended by specific types of customers such as PolicyHolder and Dependent.
 */
public abstract class Customer {
    protected String id; // Customer ID with format c-numbers (7 digits)
    protected String fullName; // Full name of the customer
    protected InsuranceCard insuranceCard; // Insurance card associated with the customer

    /**
     * Constructor to initialize a Customer object.
     *
     * @param id           The customer's ID.
     * @param fullName     The customer's full name.
     * @param insuranceCard The insurance card associated with the customer.
     */
    public Customer(String id, String fullName, InsuranceCard insuranceCard) {
        this.id = id;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    /**
     * Method to return a string representation of the customer.
     *
     * @return A string representation of the customer.
     */
    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", insuranceCard=" + insuranceCard +
                '}';
    }
}

