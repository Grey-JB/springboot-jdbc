package com.forezp.web;

import com.forezp.entity.Account;
import com.forezp.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    IAccountService accountService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;

    @RequestMapping(value = "/{type}",method = RequestMethod.GET)
    public  String addAccount(@PathVariable("type") String type){
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	//type为1顶，0为踩,count为获取数据
    	if("count".equals(type)) {
    		 return accountService.getUpCount()+","+accountService.getDownCount();
    	}
    	String ips = request.getRemoteAddr();
    	Account account = new Account();
    	account.setIpaddress(ips); 
    	account.setTime(new Date());
    	account.setType(type);
    	accountService.add(account);
    	accountService.updateCount(type);
        return accountService.getUpCount()+","+accountService.getDownCount();
    }
}
