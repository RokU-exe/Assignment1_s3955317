/**
 * @author <Le Xuan Loc - s3955317>
 */

package org.system.insurance.model;
import java.util.Date;

/**
 * Represents an insurance card in the insurance system.
 */
public class InsuranceCard {
    private String cardNumber;
    private Customer cardHolder;
    private Customer policyOwner;
    private Date expirationDate;

    /**
     * Constructor for creating an instance of InsuranceCard.
     *
     * @param cardNumber     The card's number.
     * @param cardHolder     The customer who holds this card.
     * @param policyOwner    The policy owner associated with this card.
     * @param expirationDate The expiration date of the card.
     */
    public InsuranceCard(String cardNumber, Customer cardHolder, Customer policyOwner, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    public InsuranceCard(String part, String part1, String part2, Date expirationDate) {
    }

    public InsuranceCard(String part, String part1, Date expirationDate) {
    }

    // Getters and Setters
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Customer getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(Customer cardHolder) {
        this.cardHolder = cardHolder;
    }

    public Customer getPolicyOwner() {
        return policyOwner;
    }

    public void setPolicyOwner(Customer policyOwner) {
        this.policyOwner = policyOwner;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    // Method to return a string representation of the insurance card
    @Override
    public String toString() {
        return STR."InsuranceCard{cardNumber='\{cardNumber}\{'\''}, cardHolder=\{cardHolder.getFullName()}, policyOwner=\{policyOwner.getFullName()}, expirationDate=\{expirationDate}\{'}'}";
    }
}

