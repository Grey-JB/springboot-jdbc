package com.forezp.dao;

import com.forezp.entity.Account;

import java.util.List;

public interface IAccountDAO {
    int add(Account account);

    int update(Account account);

    int delete(int id);
    
    int getUpCount();
    
    int getDownCount();
    
    int updateCount(String type);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
