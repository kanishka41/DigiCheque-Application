package com.PBL.DigiChequeApp.dto;

import com.PBL.DigiChequeApp.entity.BankAccount.AccountType;

public class RegisterRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private BankAccountDto bankAccount;
    
    // Getters and Setters
    
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
	public BankAccountDto getBankAccount() {
	        return bankAccount;
	}

	public void setBankAccount(BankAccountDto bankAccount) {
	        this.bankAccount = bankAccount;
	}
	
	
	
	public static class BankAccountDto {
        private String accountNumber;
        private AccountType accountType;
        private Double balance;
        
        
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
 
        
    }

    
    
}

