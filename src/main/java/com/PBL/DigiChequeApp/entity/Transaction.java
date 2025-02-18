package com.PBL.DigiChequeApp.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "issuer_id", nullable = false)
    private User issuer;

    @ManyToOne
    @JoinColumn(name = "payee_id", nullable = false)
    private User payee;

    private double amount;
    private String status;
    private Date transactionDate;

    public Transaction() {
        this.transactionDate = new Date();
    }
    
    // Getters and Setters
    
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public User getIssuer() {
		return issuer;
	}
	public void setIssuer(User issuer) {
		this.issuer = issuer;
	}
	public User getPayee() {
		return payee;
	}
	public void setPayee(User payee) {
		this.payee = payee;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

    
    
}
