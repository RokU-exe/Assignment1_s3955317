package org.system.insurance.model;

import java.util.Date;
import java.util.List;

/**
 * Represents an insurance claim.
 */
public class Claim {
    private String id;
    private Date claimDate;
    private Customer insuredPerson;
    private String insuredPersonId;
    private String cardNumber;
    private Date examDate;
    private List<String> documents;
    private double claimAmount;
    private String status;
    private String receiverBankingInfo;

    // Constructor
    public Claim(String id, Date claimDate, String insuredPersonId, String cardNumber, Date examDate, List<String> documents, double claimAmount, String status, String receiverBankingInfo){
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPersonId = insuredPersonId;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverBankingInfo = receiverBankingInfo;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public Customer getInsuredPerson() {
        return insuredPerson;
    }

    public void setInsuredPerson(Customer insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public List<String> getDocuments() {
        return documents;
    }

    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceiverBankingInfo() {
        return receiverBankingInfo;
    }

    public void setReceiverBankingInfo(String receiverBankingInfo) {
        this.receiverBankingInfo = receiverBankingInfo;
    }

    public String getInsuredPersonId() {
        return insuredPersonId;
    }

    public void setInsuredPersonId(String insuredPersonId) {
        this.insuredPersonId = insuredPersonId;
    }

    @Override
    public String toString() {
        return STR."Claim{id='\{id}\{'\''}, claimDate=\{claimDate}, insuredPerson=\{insuredPerson}, cardNumber='\{cardNumber}\{'\''}, examDate=\{examDate}, documents=\{documents}, claimAmount=\{claimAmount}, status='\{status}\{'\''}, receiverBankingInfo='\{receiverBankingInfo}\{'\''}\{'}'}";
    }
}

