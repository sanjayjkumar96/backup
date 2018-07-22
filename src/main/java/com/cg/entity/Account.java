package com.cg.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "WALLETACCOUNT")

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
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<TDetails> tDetails = new HashSet<TDetails>();

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
	public Set<TDetails> gettDetails() {
		return tDetails;
	}
	public void settDetails(TDetails tDetails) {
		this.tDetails.add(tDetails);
	}

	
	
	
	
	
	
}
