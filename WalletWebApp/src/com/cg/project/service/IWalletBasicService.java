package com.cg.project.service;

import com.cg.project.bean.Account;

public interface IWalletBasicService {

	
	int addAccDao(Account a);
	double depositDao(int custAccId,double money);
	double withdrawDao(int custAccId,double money);
	double showBalDao(int custAccId);
	/*boolean checkLogin(int accNo) throws WalletException;
	boolean checkPassword(String pwd);
	String currentUser();*/
	boolean transferAmt(int custAccId,int toAccNo, double money);
	void printTransdetails(int custId);
}
