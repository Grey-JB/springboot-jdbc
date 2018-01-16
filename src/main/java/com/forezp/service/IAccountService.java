package com.forezp.service;

import com.forezp.entity.Account;

import java.util.List;

public interface IAccountService {

	int add(Account account);

	int update(Account account);

	int delete(int id);

	int getUpCount();
	
	int getDownCount();

	int updateCount(String type);

	Account findAccountById(int id);

	List<Account> findAccountList();

}
