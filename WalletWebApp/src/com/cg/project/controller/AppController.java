package com.cg.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.project.bean.Account;

@Controller
public class AppController {

	
	@RequestMapping(value = "/Add")
	public String addDetails(Account a)
	{
		
		
		
		
		
		return "success.jsp";
	}
	
	@RequestMapping(value = "/LoginUser")
	public String loginPage(Account a)
	{
		
		
		
		
		
		return "success.jsp";
	}
	@RequestMapping(value = "/Deposit")
	public String depositAmt(Account a)
	{
		
		
		
		
		
		return "success.jsp";
	}
	@RequestMapping(value = "/Withdraw")
	public String wthdrwAmt(Account a)
	{
		
		
		
		
		
		return "success.jsp";
	}
	@RequestMapping(value = "/ShowBal")
	public String showBal(Account a)
	{
		
		
		
		
		
		return "success.jsp";
	}
	@RequestMapping(value = "/FundTransfer")
	public String fundTransfer(Account a)
	{
		
		
		
		
		
		return "success.jsp";
	}
	@RequestMapping(value = "/PrintTxn")
	public String printTxn(Account a)
	{
		
		
		
		
		
		return "success.jsp";
	}
	@RequestMapping(value = "/ThankYou")
	public String exitApp(Account a)
	{
		
		
		
		
		
		return "success.jsp";
	}
	
	
	
	
	
	
	
	
}
