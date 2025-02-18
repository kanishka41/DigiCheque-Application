package com.PBL.DigiChequeApp.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Cheque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chequeId;

    private Double amount;
    private String payeeName;
    private String purpose;
    private String status;
    private Date issueDate;
    private Date scheduledDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    public Cheque() {
        this.issueDate = new Date();
    }
    
    
    // Getters and Setters

	public Long getChequeId() {
		return chequeId;
	}

	public void setChequeId(Long chequeId) {
		this.chequeId = chequeId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
    
}

