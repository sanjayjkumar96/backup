package com.cg.project.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "WALLETACCOUNT")
@NamedQueries({@NamedQuery(name = "getDetails", query = "SELECT currUser FROM Account currUser WHERE currUser.accNum =:id" )})
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CUSTID")
	private int accNum;
	@Column(name = "CUSTNAME")
	private String custName;
	@Column(name = "CUSTPHONE")
	private String custPhoneNo;
	@Column(name = "CUSTAGE")
	private int custAge;
	@Column(name = "CSUTBAL")
	private double custBal;
	@Column(name = "CUSTPWD")
	private String custPwd;
	public int getAccNum() {
		return accNum;
	}
	public void setAccNum() {
		 int max =1000,min =999;
		 this.accNum = (int) ((max-min)*min*Math.random());
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustPhoneNo() {
		return custPhoneNo;
	}
	public void setCustPhoneNo(String custPhoneNo) {
		this.custPhoneNo = custPhoneNo;
	}
	public int getCustAge() {
		return custAge;
	}
	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}
	public double getCustBal() {
		return custBal;
	}
	public void setCustBal(double custBal) {
		this.custBal = custBal;
	}
	public String getCustPwd() {
		return custPwd;
	}
	public void setCustPwd(String custPwd) {
		this.custPwd = custPwd;
	}
	
	
	
}
