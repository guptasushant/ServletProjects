package com.web.bankdao;

import com.web.bank.Bank;

public interface BankDao {
	void Insert(Bank bank);
 	void Delete(int id);
	boolean saveBank(Bank bank);
	Bank Fetch(int id);
	Bank Update(int id,Bank bank);
	//BankDao Update(int id);
}
