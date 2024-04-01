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
    private String cardHolderId; // Assuming you use IDs to link to the Customer object
    private String policyOwnerId; // Same assumption as above
    private Date expirationDate;

    /**
     * Constructor for creating an instance of InsuranceCard.
     *
     * @param cardNumber     The card's number.
     * @param cardHolderId   The customer who holds this card.
     * @param expirationDate The expiration date of the card.
     */
    // Constructor
    public InsuranceCard(String cardNumber, String cardHolderId, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolderId = cardHolderId;
        this.policyOwnerId = policyOwnerId;
        this.expirationDate = expirationDate;
    }

    // Getters and setters
    public String getCardNumber() { return cardNumber; }
    public String getCardHolderId() { return cardHolderId; }
    public String getPolicyOwnerId() { return policyOwnerId; }
    public Date getExpirationDate() { return expirationDate; }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardHolderId(String cardHolderId) {
        this.cardHolderId = cardHolderId;
    }

    public void setPolicyOwnerId(String policyOwnerId) {
        this.policyOwnerId = policyOwnerId;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "InsuranceCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardHolderId='" + cardHolderId + '\'' +
                ", policyOwnerId='" + policyOwnerId + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}