/*package com.cg.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Account;
import com.cg.entity.TDetails;
import com.cg.exception.WalletException;
@Repository
public class WalletDBAccess  {
	
	private EntityManager manager;
	
	
	public WalletDBAccess() {
		super();
	
	}
	
	public int accCreation(Account a) throws WalletException {
		
		try {
		
	
		manager.persist(a);
		
		
		return a.getAccNum();}
		catch (Exception e) {
			throw new WalletException("Insertion error");
		}
	}

	public Account loginUser(int accNo) throws WalletException {
	
		try{
			
		
		
		Account tempLogin =new Account();
		tempLogin = manager.find(Account.class, accNo);
		
		
	
		return tempLogin;
		}
		catch (Exception e) {
			throw new WalletException("Login Check error");
		}
	}
	
	public void updateDetails(int accNo, Account a) throws WalletException {
		try{
			
			
		
		manager.merge(a);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<TDetails> fetchTransaction(int accNum) throws WalletException {
		
		List<TDetails> list = new ArrayList<TDetails>();
		TypedQuery<TDetails> query = manager.createNamedQuery("getTDetails", TDetails.class);
		query.setParameter("id", accNum);
		list = query.getResultList();
	
		return list;
	}

}
*/