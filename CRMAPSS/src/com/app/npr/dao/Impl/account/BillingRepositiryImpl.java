package com.app.npr.dao.Impl.account;

import org.springframework.stereotype.Repository;

import com.app.npr.dao.Impl.users.AbstractDao;
import com.app.npr.dao.account.BillingAddressRepository;
import com.app.npr.model.account.BillingAddress;

@Repository("BillingRepositiryImpl")
public class BillingRepositiryImpl extends AbstractDao<Integer, BillingAddress> implements BillingAddressRepository{

}
