/**
 * @author <Le Xuan Loc - s3955317>
 */

package org.system.insurance.model;

/**
 * Represents a dependent of a policyholder in the insurance system.
 */
public class Dependent extends Customer {
    /**
     * Constructor for a Dependent.
     *
     * @param id            The dependent's ID, following the format c-numbers (7 numbers).
     * @param fullName      The full name of the dependent.
     * @param insuranceCard The insurance card associated with the dependent.
     */
    public Dependent(String id, String fullName, InsuranceCard insuranceCard) {
        super(id, fullName, insuranceCard);
    }
}

