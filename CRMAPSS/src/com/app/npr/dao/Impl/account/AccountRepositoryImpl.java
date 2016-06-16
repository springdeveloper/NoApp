package com.app.npr.dao.Impl.account;

import org.springframework.stereotype.Repository;

import com.app.npr.dao.account.AccountRepository;
import com.app.npr.dao.genric.BaseHibernateJPARepository;
import com.app.npr.model.account.Account;

@Repository("AccountRepositoryImpl")
public class AccountRepositoryImpl extends BaseHibernateJPARepository<Account, Integer> implements AccountRepository{

}
