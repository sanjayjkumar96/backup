package com.cg.service;

import java.util.List;

import com.cg.entity.Account;
import com.cg.entity.TDetails;
import com.cg.exception.WalletException;

public interface IWalletBasicService {

	
	int addAccDao(Account a) throws WalletException;
	double depositDao(int custAccId,double money) throws WalletException;
	double withdrawDao(int custAccId,double money) throws WalletException ;
	double showBalDao(int custAccId);
	boolean checkLogin(int accNo) throws WalletException;
	boolean checkPassword(String pwd);
	String currentUser();
	boolean transferAmt(int custAccId,int toAccNo, double money) throws WalletException;
	List<TDetails> printTransdetails(int custId) throws WalletException;
	public  boolean validateCustName(String name);
	public  boolean validateCustPhoneNumber(String number);
	public boolean validateCustAge(int age);
	public  boolean validateCustPwd(String pwd);
	public  boolean validateAmt(double amt);
	
}
