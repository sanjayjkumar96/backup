package com.cg.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.project.bean.Account;

public interface IWalletDBAccess extends JpaRepository<Account, Integer> {

	int accCreation(Account a);
	
	Account loginUser(int accNo);
	
	void updateDetails(int accNo, Account a);
	
	
	
}
