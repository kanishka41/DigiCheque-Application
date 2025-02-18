package com.PBL.DigiChequeApp.entity;

import jakarta.persistence.*;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;

    @Column(nullable = false)
    private Double balance = 0.0;

    @OneToOne(mappedBy = "bankAccount")
    private User user;

    // Constructors
    public BankAccount() {}

    public BankAccount(String accountNumber, AccountType accountType, Double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Getters and Setters
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
               "accountId=" + accountId +
               ", accountNumber='" + accountNumber + '\'' +
               ", accountType=" + accountType +
               ", balance=" + balance +
               '}';
    }
    
    // enum for Account Type
    public enum AccountType {
        SAVINGS,
        CURRENT
    }
}


