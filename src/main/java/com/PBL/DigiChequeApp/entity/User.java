package com.PBL.DigiChequeApp.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;
    
    private String verificationCode;  // Store the verification code temporarily
    private String status = "PENDING_VERIFICATION";  // Status of the user

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cheque> cheques;

    // Constructors
    public User() {}

    public User(String name, String email, String phoneNumber, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    
    // Getters and Setters
    
	public long getUserId() {
		return id;
	}

	public void setUserId(Long userId) {
		this.id = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public List<Cheque> getCheques() {
		return cheques;
	}

	public void setCheques(List<Cheque> cheques) {
		this.cheques = cheques;
	}
	
	
	
	 public String getVerificationCode() {
	        return verificationCode;
	    }

	    public void setVerificationCode(String verificationCode) {
	        this.verificationCode = verificationCode;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
    
    
}
