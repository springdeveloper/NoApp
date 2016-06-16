package com.app.npr.dao.Impl.lead;

import org.springframework.stereotype.Repository;

import com.app.npr.dao.genric.BaseHibernateJPARepository;
import com.app.npr.dao.lead.AddressRepository;
import com.app.npr.model.lead.Address;

@Repository("addressRepositoryImpl")
public class AddressRepositoryImpl extends BaseHibernateJPARepository<Address, Long> implements AddressRepository{

}
