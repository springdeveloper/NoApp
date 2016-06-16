package com.app.npr.service.Impl.account;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.npr.dao.account.AccountRepository;
import com.app.npr.dao.genric.BaseJPAServiceImpl;
import com.app.npr.model.account.Account;


@Service("AccountServiceImpl")
public class AccountServiceImpl extends BaseJPAServiceImpl<Account, Integer> {
	  private @Autowired 
	  AccountRepository accountRepository;

	    @PostConstruct
	    public void setupService() {
	        this.baseJpaRepository = accountRepository;
	        this.entityClass = Account.class;
	        this.baseJpaRepository.setupEntityClass(Account.class);
	    }

}
