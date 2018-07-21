package com.cg.project.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.project.bean.Account;
import com.cg.project.repository.IWalletDBAccess;

public class WalletBasicService implements IWalletBasicService {
	
	Account temp = new Account();
	
	IWalletDBAccess dao;
	
	@Autowired
	 public WalletBasicService(IWalletDBAccess daoObj) {
		 this.dao = daoObj;
		 
	}
	 LocalDate tDate = LocalDate.now();
	 static String namePattern = "[A-Z]{1}[a-z]{2,}";
	 static String numberPattern = "(\\d){10}";
	 static String passwordPattern = "[A-Z]{1}[a-z]{2,6}(\\d){1,4}(\\W){1}";
	
	 public  boolean validateCustName(String name)
	 {	if(name.matches(namePattern))
	 		return true;
	 	else
	 		return false;
	 }
	 
	 
	 public  boolean validateCustPhoneNumber(String number) {
			if(number.matches(numberPattern))
				return true;
			else
				return false;
		}
	 
	 
public boolean validateCustAge(int age) {
	if(age<=110&&age>=1)
		return true;
	else
		return false;
	
}

public  boolean validateCustPwd(String pwd) {
	if(pwd.matches(passwordPattern))
		return true;
	else
		return false;
}

public  boolean validateAmt(double amt) {
if(amt>0.00)
	return true;
else
	return false;
}

public int addAccDao(Account a)  {
	return dao.accCreation(a);
}

public double depositDao(int custAccId,double money)  {
	temp.setCustBal(temp.getCustBal()+money);
	/*temp.settDetails("Depsoited Amount :"+money+" Total Balance :"+temp.getCustBal());*/
	dao.updateDetails(custAccId,temp);
	return temp.getCustBal();
}

public double withdrawDao(int custAccId,double money)  {
	if(money<temp.getCustBal()) {
		temp.setCustBal(temp.getCustBal()-money);
		/*temp.settDetails("Date :"+tDate+" Amount Withdrawn :"+money+" Total Balance :"+temp.getCustBal());*/
		dao.updateDetails(custAccId,temp);
		}
		else
			System.out.println(" Low Balance :( ");
		return temp.getCustBal();
}

public double showBalDao(int custAccId) {
	return temp.getCustBal();
}

public boolean checkLogin(int accNo)  {
	temp =dao.loginUser(accNo);
	if(temp!=null)
	return true;
	else 
		return false;
}

public boolean checkPassword(String pwd) {
	if(temp.getCustPwd().matches(pwd))
		return true;
	else
		return false;
}

public String currentUser() {
	return temp.getCustName();
}

public boolean transferAmt(int custAccId,int toAccNo, double money) {
	Account ftTemp =new Account();
	if(temp.getCustBal()>=money) {
	ftTemp = dao.loginUser(toAccNo);
	if(ftTemp!=null)
	{
		ftTemp.setCustBal(ftTemp.getCustBal()+money);
		temp.setCustBal(temp.getCustBal()-money);
		/*temp.settDetails("Date :"+tDate+" Amount Transfered :"+money+" To Acc No: "+ftTemp.getAccNum()+" Total Balance :"+temp.getCustBal());
		ftTemp.settDetails("Date :"+tDate+" Depsoited Amount :"+money+" From Acc No: "+temp.getAccNum()+" Total Balance :"+ftTemp.getCustBal());*/
		dao.updateDetails(custAccId, temp);
		dao.updateDetails(ftTemp.getAccNum(), ftTemp);
		return true;
	}
	
	
}
	else if(temp.getCustBal()<money)
	{
		System.out.println("Low Balance to transfer");
	}
	
	else
		System.out.println("No such user account");
	return false;
}

public void printTransdetails(int custId)  {
	/*Stack<String> tempDetails = new Stack<String>();
	tempDetails = dao.getTransactionDetails(custId);
	Stream printList = tempDetails.stream();
	printList.forEach(System.out::println);*/
	
}


	
}



