/**
 * @author <Le Xuan Loc - s3955317>
 */

package org.system.insurance.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;


/**
 * Represents a policyholder in the insurance system. Inherits from Customer and adds
 * the capability to have dependents.
 */
public class PolicyHolder extends Customer {
    private List<Dependent> dependents;

    @Override
    public String toString() {
        return "PolicyHolder{" +
                "dependents=" + dependents +
                ", id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", insuranceCard=" + insuranceCard +
                '}';
    }

    /**
     * Constructor for creating an instance of PolicyHolder.
     *
     * @param id            The policyholder's ID, following the format c-numbers (7 digits).
     * @param fullName      The full name of the policyholder.
     * @param insuranceCard The insurance card associated with the policyholder.
     */
    // Constructor
    public PolicyHolder(String id, String fullName, InsuranceCard insuranceCard) {
        super(id, fullName, insuranceCard);
        this.dependents = new ArrayList<>();
    }
    public void addDependent(Dependent dependent) {
        if (this.dependents == null) {
            this.dependents = new ArrayList<>();
        }
        this.dependents.add(dependent);
    }
    public List<Dependent> getDependents() {
        return this.dependents;
    }
}