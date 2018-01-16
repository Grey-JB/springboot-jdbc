package com.forezp.dao.impl;

import com.forezp.dao.IAccountDAO;
import com.forezp.entity.Account;
import com.forezp.entity.Count;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements IAccountDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int add(Account account) {
		return jdbcTemplate.update("insert into account(ipaddress,type,time) values(?,?,?)", account.getIpaddress(), account.getType(),
				account.getTime());

	}

	@Override
	public int update(Account account) {
		return jdbcTemplate.update("UPDATE  account SET ipaddress=? ,type=? ,time=? WHERE id=?", account.getIpaddress(), account.getType(),
				account.getTime(), account.getId());
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE from TABLE account where id=?", id);
	}

	@Override
	public Account findAccountById(int id) {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Account> list = jdbcTemplate.query("select * from account where id = ?", new Object[] { id },
				new BeanPropertyRowMapper(Account.class));
		if (list != null && list.size() > 0) {
			Account account = list.get(0);
			return account;
		} else {
			return null;
		}
	}

	@Override
	public List<Account> findAccountList() {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Account> list = jdbcTemplate.query("select * from account", new Object[] {}, new BeanPropertyRowMapper(Account.class));
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public int getUpCount() {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Count> list = jdbcTemplate.query("select * from count where id = 1", new Object[] {}, new BeanPropertyRowMapper(Count.class));
		if (list != null && list.size() > 0) {
			return list.get(0).getCount();
		} else {
			return 0;
		}
	}
	@Override
	public int getDownCount() {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Count> list = jdbcTemplate.query("select * from count where id = 2", new Object[] {}, new BeanPropertyRowMapper(Count.class));
		if (list != null && list.size() > 0) {
			return list.get(0).getCount();
		} else {
			return 0;
		}
	}

	@Override
	public int updateCount(String type) {
		if("1".equals(type)){
			return jdbcTemplate.update("UPDATE  count SET count=? where id=1", getUpCount()+1);
		}else{
			return jdbcTemplate.update("UPDATE  count SET count=? where id=2", getDownCount()+1);
		}
		
	}
}
