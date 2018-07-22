package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.entity.Account;
import com.cg.entity.TDetails;
import com.cg.exception.WalletException;

public interface IWalletDBAccess extends JpaRepository<Account,Integer> {


	@Query(value = "SELECT currUser FROM Account currUser WHERE currUser.accNum=?1")
	Account loginUser(int accNo) throws WalletException;
	
	
	@Query(value="SELECT tr FROM TDetails tr WHERE account.accNum =?1")
	List<TDetails> fetchTransaction(int accNum) throws WalletException;
	
}
