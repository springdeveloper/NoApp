package com.app.npr.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.npr.dao.account.AccountRepository;
import com.app.npr.dto.AccountForm;
import com.app.npr.dto.LeadForm;
import com.app.npr.model.account.Account;
import com.app.npr.util.UrlApi;

@Controller
@RequestMapping("/acc")
public class AccountController {

	public static Logger LOG = LoggerFactory.getLogger(AccountController.class);
	@Autowired
	private AccountRepository accountRepository;

	@RequestMapping(value = UrlApi.CREATE_ACCOUNT, method = RequestMethod.GET)
	public String createAccount(Model model) {
		model.addAttribute("account", new AccountForm());
		model.addAttribute("lead", new LeadForm());
		model.addAttribute(UrlApi.ACC_TEMPLATE_TITLE, UrlApi.ACCOUNT_CREATE_PAGE);
		model.addAttribute(UrlApi.ACC_CREATE_PAGE_TITLE, UrlApi.ACC_CREATE_PAGE_TITLE_NAME);
		return UrlApi.ACCOUNT_TEMPLATES;
	}
	
	@RequestMapping(value = UrlApi.CREATE_ACCOUNT, method = RequestMethod.POST)
	public String saveAccount(@Valid Account account,Model model,BindingResult result ) {
		model.addAttribute("account", new AccountForm());
		model.addAttribute("lead", new LeadForm());
		model.addAttribute(UrlApi.ACC_TEMPLATE_TITLE, UrlApi.ACCOUNT_CREATE_PAGE);
		model.addAttribute(UrlApi.ACC_CREATE_PAGE_TITLE, UrlApi.ACC_CREATE_PAGE_TITLE_NAME);
		System.out.println("----------------99999999999999>>>>>>>>"+result.hasErrors());
		
		return UrlApi.ACCOUNT_TEMPLATES;
	}
	
	
	

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

}
