package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Account;
import com.cg.entity.TDetails;
import com.cg.exception.WalletException;
import com.cg.repository.IWalletDBAccess;
@Service(value="service")
public class WalletBasicService implements IWalletBasicService {
	@Autowired
	private IWalletDBAccess dao;
	
	public IWalletDBAccess getDao() {
		return dao;
	}


	public void setDao(IWalletDBAccess dao) {
		this.dao = dao;
	}

	Account temp = new Account();
	
	 LocalDate tDate = LocalDate.now();
	 static String namePattern = "[A-Z]{1}[a-z]{2,}";
	 static String numberPattern = "(\\d){10}";
	 static String passwordPattern = "[A-Z]{1}[a-z]{2,6}(\\d){1,4}(\\W){1}";
	@Override
	 public  boolean validateCustName(String name)
	 {	if(name.matches(namePattern))
	 		return true;
	 	else
	 		return false;
	 }
	 
	@Override
	 public  boolean validateCustPhoneNumber(String number) {
			if(number.matches(numberPattern))
				return true;
			else
				return false;
		}
	 
	@Override 
public boolean validateCustAge(int age) {
	if(age<=110&&age>=1)
		return true;
	else
		return false;
	
}
	@Override
public  boolean validateCustPwd(String pwd) {
	if(pwd.matches(passwordPattern))
		return true;
	else
		return false;
}
	@Override
public  boolean validateAmt(double amt) {
if(amt>0.00)
	return true;
else
	return false;
}
	@Override
public int addAccDao(Account a) throws WalletException {
	a.setAccNum();
	TDetails crTxn = new TDetails();
	crTxn.setTxns("Account created on :"+tDate+" with initial Balance :"+ a.getCustBal());
	crTxn.setAccount(a);
	a.settDetails(crTxn);
	temp = dao.save(a);
	return temp.getAccNum();
}
	@Override
public double depositDao(int custAccId,double money) throws WalletException {
	temp.setCustBal(temp.getCustBal()+money);
	TDetails updTxn = new TDetails();
	updTxn.setTxns("Date :"+tDate+" Depsoited Amount :"+money+" Total Balance :"+temp.getCustBal());
	updTxn.setAccount(temp);
	temp.settDetails(updTxn);
	dao.save(temp);
	return temp.getCustBal();
}
	@Override
public double withdrawDao(int custAccId,double money) throws WalletException {
	if(money<temp.getCustBal()) {
		temp.setCustBal(temp.getCustBal()-money);
		TDetails updTxn = new TDetails();
		updTxn.setTxns("Date :"+tDate+" Amount Withdrawn :"+money+" Total Balance :"+temp.getCustBal());
		updTxn.setAccount(temp);
		temp.settDetails(updTxn);
		
		dao.save(temp);
		}
		else
			System.out.println(" Low Balance :( ");
		return temp.getCustBal();
}
	@Override
public double showBalDao(int custAccId) {
	return temp.getCustBal();
}
	@Override
public boolean checkLogin(int accNo) throws WalletException {
	temp =dao.loginUser(accNo);
	if(temp!=null)
	return true;
	else 
		return false;
}
	@Override
public boolean checkPassword(String pwd) {
	if(temp.getCustPwd().matches(pwd))
		return true;
	else
		return false;
}
	@Override
public String currentUser() {
	return temp.getCustName();
}
	@Override
public boolean transferAmt(int custAccId,int toAccNo, double money) throws WalletException {
	Account ftTemp =new Account();
	if(temp.getCustBal()>=money) {
	ftTemp = dao.findOne(toAccNo);
	
	
	if(ftTemp!=null)
	{
		ftTemp.setCustBal(ftTemp.getCustBal()+money);
		temp.setCustBal(temp.getCustBal()-money);
		TDetails updTxn = new TDetails();
		updTxn.setTxns("Date :"+tDate+" Amount Transfered :"+money+" To Acc No: "+ftTemp.getAccNum()+" Total Balance :"+temp.getCustBal());
		updTxn.setAccount(temp);
		temp.settDetails(updTxn);
		TDetails ftUpdTxn = new TDetails();
		ftUpdTxn.setTxns("Date :"+tDate+" Depsoited Amount :"+money+" From Acc No: "+temp.getAccNum()+" Total Balance :"+ftTemp.getCustBal());
		ftUpdTxn.setAccount(ftTemp);
		ftTemp.settDetails(ftUpdTxn);
		dao.save(temp);
		dao.save(ftTemp);
		return true;
	}
	else
		System.out.println("No such user account");
	return false;
	
	
}
	else 
	{
		System.out.println("Low Balance to transfer");
		return false;
	}
	
	
}
	@Override
public List<TDetails> printTransdetails(int custId) throws WalletException {
	return dao.fetchTransaction(custId);
	
}


	
}



