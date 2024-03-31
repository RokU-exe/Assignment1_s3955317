/**
 * @author <Le Xuan Loc - s3955317>
 */

package org.system.insurance.model;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a policyholder in the insurance system. Inherits from Customer and adds
 * the capability to have dependents.
 */
public class PolicyHolder extends Customer {
    private List<Dependent> dependents; // List to store the policyholder's dependents

    /**
     * Constructor for creating an instance of PolicyHolder.
     *
     * @param id            The policyholder's ID, following the format c-numbers (7 digits).
     * @param fullName      The full name of the policyholder.
     * @param insuranceCard The insurance card associated with the policyholder.
     */
    public PolicyHolder(String id, String fullName, InsuranceCard insuranceCard) {
        super(id, fullName, insuranceCard);
        this.dependents = new ArrayList<>();
    }

    /**
     * Adds a dependent to the policyholder's list of dependents.
     *
     * @param dependent The dependent to add.
     */
    public void addDependent(Dependent dependent) {
        dependents.add(dependent);
    }

    /**
     * Removes a dependent from the policyholder's list of dependents.
     *
     * @param dependent The dependent to remove.
     */
    public void removeDependent(Dependent dependent) {
        dependents.remove(dependent);
    }

    /**
     * Gets the list of dependents for the policyholder.
     *
     * @return The list of dependents.
     */
    public List<Dependent> getDependents() {
        return dependents;
    }

    // Method to return a string representation of the policyholder
    @Override
    public String toString() {
        return "PolicyHolder{" +
                "id='" + getId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", insuranceCard=" + getInsuranceCard() +
                ", dependents=" + dependents.stream().map(Dependent::getFullName).toList() +
                '}';
    }
}

