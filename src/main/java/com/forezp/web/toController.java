package com.forezp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.forezp.service.IAccountService;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

@Controller
public class toController {
	@Autowired
	IAccountService accountService;
	@Autowired
	HttpServletRequest request;

	/**
	 * 访问hello.html
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/hello")
	public String helloHtml(HashMap<String, Object> map) {
		map.put("hello", "hello");
		return "/hello";
	}

}
