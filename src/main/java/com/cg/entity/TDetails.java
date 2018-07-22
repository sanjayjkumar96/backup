package com.cg.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Transactions")
@NamedQueries({@NamedQuery(name = "getTDetails", query = "SELECT currUser FROM TDetails currUser WHERE account.accNum =:id" )})
public class TDetails implements Serializable {
	
	
	
	
	@ManyToOne
	private Account account;
	@Id
	private String txns;
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getTxns() {
		return txns;
	}

	public void setTxns(String txns) {
		this.txns = txns;
	}

	@Override
	public String toString() {
		return "TDetails [account=" + account + ", txns=" + txns + "]";
	}

	
	
	
	
}
