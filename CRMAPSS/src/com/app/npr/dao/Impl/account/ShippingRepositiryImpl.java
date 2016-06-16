package com.app.npr.dao.Impl.account;

import org.springframework.stereotype.Repository;

import com.app.npr.dao.Impl.users.AbstractDao;
import com.app.npr.dao.account.ShippingAddressRepository;
import com.app.npr.model.account.ShippingAddress;

@Repository("ShippingRepositiryImpl")
public class ShippingRepositiryImpl extends AbstractDao<Integer, ShippingAddress> implements ShippingAddressRepository{

}
